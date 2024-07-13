package com.javid.order.service;

import com.javid.order.model.request.OrderProductRequest;
import com.javid.order.model.response.OrderProductResponse;

public interface OrderProductService {
    OrderProductResponse createOrderLine(OrderProductRequest orderLineRequest);
}
