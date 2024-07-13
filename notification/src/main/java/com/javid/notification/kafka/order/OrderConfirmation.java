package com.javid.notification.kafka.order;

import com.javid.notification.kafka.payment.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderConfirmation {
    private Integer orderId;
    private BigDecimal totalPrice;
    private PaymentMethod paymentMethod;
    private CustomerResponse customerResponse;
    private List<ProductOrderRequest> productOrderRequests;
}
