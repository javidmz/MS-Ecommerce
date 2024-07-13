package com.javid.product.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderDTO {
    @NotNull(message = "Please, provide product ID")
    private int productId;

    @NotNull
    @Positive(message = "Please, provide number of quantity")
    private int quantity;
}
