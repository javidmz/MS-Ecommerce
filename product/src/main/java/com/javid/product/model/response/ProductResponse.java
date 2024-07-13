package com.javid.product.model.response;

import com.javid.product.model.CategoryDTO;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private int availableQuantity;
    private CategoryDTO category;
}
