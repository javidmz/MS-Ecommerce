package com.javid.payment.mapper;

import com.javid.payment.entity.Payment;
import com.javid.payment.model.request.PaymentRequest;
import com.javid.payment.model.response.PaymentResponse;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest payment) {
        return Payment.builder()
                .amount(payment.getAmount())
                .orderId(payment.getOrderId())
                .paymentMethod(payment.getPaymentMethod())
                .build();
    }

    public PaymentResponse toPaymentResponse(Payment payment) {
        return PaymentResponse.builder()
                .id(payment.getId())
                .amount(payment.getAmount())
                .paymentMethod(payment.getPaymentMethod())
                .orderId(payment.getOrderId())
                .build();
    }
}
