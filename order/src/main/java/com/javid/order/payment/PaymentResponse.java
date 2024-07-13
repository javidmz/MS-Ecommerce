package com.javid.order.payment;

import com.javid.order.customer.CustomerResponse;
import com.javid.order.entity.PaymentMethod;
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

