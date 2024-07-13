package com.javid.order.model.request;

import com.javid.order.entity.Order;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProductRequest {
    private Integer productId;
    private Order order;
    private int quantity;
}
