package com.javid.order.kafka;

import com.javid.order.customer.CustomerResponse;
import com.javid.order.entity.PaymentMethod;
import com.javid.order.product.ProductOrderRequest;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
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
