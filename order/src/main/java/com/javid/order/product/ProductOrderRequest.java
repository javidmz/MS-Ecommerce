package com.javid.order.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderRequest {
    @NotNull(message = "Product ID is required")
    private Integer productId;

    @Positive(message = "You should select at least one item")
    private int quantity;
}
