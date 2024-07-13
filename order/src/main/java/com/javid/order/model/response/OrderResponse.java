package com.javid.order.model.response;

import com.javid.order.entity.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    private int id;
    private BigDecimal price;
    private Long customerId;
    private PaymentMethod paymentMethod;
}
