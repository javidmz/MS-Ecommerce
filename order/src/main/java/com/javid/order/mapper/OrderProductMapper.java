package com.javid.order.mapper;

import com.javid.order.entity.OrderProduct;
import com.javid.order.model.request.OrderProductRequest;
import com.javid.order.model.response.OrderProductResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderProductMapper {
    public OrderProduct toOrderProduct(OrderProductRequest orderProductRequest) {
        return OrderProduct.builder()
                .order(orderProductRequest.getOrder())
                .productId(orderProductRequest.getProductId())
                .quantity(orderProductRequest.getQuantity())
                .build();
    }

    public OrderProductResponse toOrderProductResponse(OrderProduct orderProduct) {
        return OrderProductResponse.builder()
                .id(orderProduct.getId())
                .orderId(orderProduct.getId())
                .productId(orderProduct.getProductId())
                .quantity(orderProduct.getQuantity())
                .build();
    }
}
