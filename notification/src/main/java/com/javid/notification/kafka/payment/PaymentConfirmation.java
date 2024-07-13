package com.javid.notification.kafka.payment;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentConfirmation {
    private Integer orderId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customerResponse;
}
