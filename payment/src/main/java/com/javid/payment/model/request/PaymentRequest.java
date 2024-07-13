package com.javid.payment.model.request;

import com.javid.payment.entity.PaymentMethod;
import com.javid.payment.model.CustomerResponse;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    @NotNull(message = "Please, provide the amount of payment")
    private BigDecimal amount;

    @NotNull(message = "Please, identify order ID")
    private Integer orderId;

    @NotNull(message = "Please, select Payment Method")
    private PaymentMethod paymentMethod;

    private CustomerResponse customerResponse;
}
