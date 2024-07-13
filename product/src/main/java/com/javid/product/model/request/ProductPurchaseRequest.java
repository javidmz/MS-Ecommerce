package com.javid.product.model.request;

import com.javid.product.model.ProductOrderDTO;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPurchaseRequest {
    @NotNull(message = "Please, provide products that you want to order")
    List<ProductOrderDTO> productOrders;
}
