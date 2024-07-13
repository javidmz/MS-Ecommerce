package com.javid.notification.kafka.order;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderRequest {
    private Integer productId;
    private int quantity;
}
