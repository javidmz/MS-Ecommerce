package com.javid.product.model.response;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseResponse {
    private BigDecimal totalPrice;
}
