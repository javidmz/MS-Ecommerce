package com.javid.payment.model.response;

import com.javid.payment.entity.PaymentMethod;
import com.javid.payment.model.CustomerResponse;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentResponse {
    private Integer id;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private Integer orderId;
    private CustomerResponse customerDTO;
}
