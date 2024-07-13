package com.javid.payment.service;

import com.javid.payment.model.request.PaymentRequest;
import com.javid.payment.model.response.PaymentResponse;

public interface PaymentService {
    PaymentResponse createPayment(PaymentRequest paymentRequest);
}
