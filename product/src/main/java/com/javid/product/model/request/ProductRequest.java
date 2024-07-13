package com.javid.product.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    @NotBlank(message = "Product name is required")
    private String productName;

    @NotBlank(message = "Product description is required")
    private String description;

    @NotNull(message = "Product Price is required")
    private BigDecimal price;

    @Positive(message = "Available Quantity is required")
    private int availableQuantity;

    @NotNull(message = "Category ID is required")
    private int categoryId;
}
