package com.javid.order.service;

import com.javid.order.entity.OrderProduct;
import com.javid.order.mapper.OrderProductMapper;
import com.javid.order.model.request.OrderProductRequest;
import com.javid.order.model.response.OrderProductResponse;
import com.javid.order.repository.OrderProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository orderProductRepository;
    private final OrderProductMapper orderProductMapper;

    @Override
    public OrderProductResponse createOrderLine(OrderProductRequest orderLineRequest) {
        OrderProduct orderProduct = orderProductRepository.save(
                orderProductMapper.toOrderProduct(orderLineRequest)
        );

        return orderProductMapper.toOrderProductResponse(orderProduct);
    }
}
