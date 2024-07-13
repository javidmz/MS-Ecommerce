package com.javid.order.model.request;

import com.javid.order.entity.PaymentMethod;
import com.javid.order.product.ProductOrderRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderRequest {
    @Positive(message = "Price should be positive")
    private BigDecimal price;

    @NotNull(message = "Payment Method is required")
    private PaymentMethod paymentMethod;

    @Positive(message = "Customer ID is required")
    private Long customerId;

    @NotEmpty(message = "You should order at least one product.")
    List<ProductOrderRequest> productOrderList;
}
