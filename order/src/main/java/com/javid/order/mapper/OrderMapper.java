package com.javid.order.mapper;

import com.javid.order.entity.Order;
import com.javid.order.entity.OrderProduct;
import com.javid.order.model.request.OrderRequest;
import com.javid.order.model.response.OrderResponse;
import com.javid.order.product.ProductOrderRequest;
import org.springframework.stereotype.Service;

@Service
public class OrderMapper {
    public Order toOrder(OrderRequest orderRequest) {
        return Order.builder()
                .customerId(orderRequest.getCustomerId())
                .totalPrice(orderRequest.getPrice())
                .paymentMethod(orderRequest.getPaymentMethod())
                .customerId(orderRequest.getCustomerId())
                .build();
    }

    public OrderResponse toOrderProduct(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .price(order.getTotalPrice())
                .paymentMethod(order.getPaymentMethod())
                .customerId(order.getCustomerId())
                .build();
    }
}
