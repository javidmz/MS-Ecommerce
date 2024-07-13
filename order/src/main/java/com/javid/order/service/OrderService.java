package com.javid.order.service;

import com.javid.order.model.request.OrderRequest;
import com.javid.order.model.response.OrderResponse;

public interface OrderService {
    OrderResponse createOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(int orderId);
}
