package com.javid.order.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProductResponse {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private int quantity;
}
