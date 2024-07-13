package com.javid.payment.notification;

import com.javid.payment.entity.PaymentMethod;
import com.javid.payment.model.CustomerResponse;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentNotificationRequest {
    private Integer orderId;
    private BigDecimal amount;
    private PaymentMethod paymentMethod;
    private CustomerResponse customerResponse;
}
