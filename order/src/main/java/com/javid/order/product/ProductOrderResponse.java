package com.javid.order.product;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderResponse {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
}
