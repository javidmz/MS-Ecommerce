package com.javid.order.service;

import com.javid.order.customer.CustomerClient;
import com.javid.order.customer.CustomerResponse;
import com.javid.order.entity.Order;
import com.javid.order.exception.OrderNotFoundException;
import com.javid.order.kafka.OrderConfirmation;
import com.javid.order.kafka.OrderProducer;
import com.javid.order.mapper.OrderMapper;
import com.javid.order.model.request.OrderProductRequest;
import com.javid.order.model.request.OrderRequest;
import com.javid.order.model.response.OrderResponse;
import com.javid.order.payment.PaymentClient;
import com.javid.order.payment.PaymentRequest;
import com.javid.order.product.ProductClient;
import com.javid.order.product.ProductOrderRequest;
import com.javid.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderProductService orderLineService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest) {
        CustomerResponse customer  = customerClient.getCustomer(orderRequest.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        productClient.purchaseProduct(orderRequest.getProductOrderList());

        Order order = orderRepository.save(orderMapper.toOrder(orderRequest));

        for(ProductOrderRequest productOrderRequest : orderRequest.getProductOrderList())
            orderLineService.createOrderLine(OrderProductRequest.builder()
                    .order(order)
                    .productId(productOrderRequest.getProductId())
                    .quantity(productOrderRequest.getQuantity())
                    .build()
            );

        paymentClient.createPayment(
                PaymentRequest.builder()
                        .amount(order.getTotalPrice())
                        .orderId(order.getId())
                        .paymentMethod(order.getPaymentMethod())
                        .customerResponse(customer)
                        .build()
        );

        orderProducer.sendOrderConfirmation(
                OrderConfirmation.builder()
                        .orderId(order.getId())
                        .totalPrice(order.getTotalPrice())
                        .customerResponse(customer)
                        .paymentMethod(orderRequest.getPaymentMethod())
                        .productOrderRequests(orderRequest.getProductOrderList())
                        .build()
        );

        return orderMapper.toOrderProduct(order);
    }

    @Override
    public OrderResponse getOrderById(int orderId) {
        return orderRepository.findById(orderId)
                .map(orderMapper::toOrderProduct)
                .orElseThrow(() -> new OrderNotFoundException("Such order does not exist!"));
    }
}
