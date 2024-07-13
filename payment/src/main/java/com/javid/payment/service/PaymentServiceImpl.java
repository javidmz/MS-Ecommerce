package com.javid.payment.service;

import com.javid.payment.entity.Payment;
import com.javid.payment.mapper.PaymentMapper;
import com.javid.payment.model.request.PaymentRequest;
import com.javid.payment.model.response.PaymentResponse;
import com.javid.payment.notification.NotificationProducer;
import com.javid.payment.notification.PaymentNotificationRequest;
import com.javid.payment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    @Override
    public PaymentResponse createPayment(PaymentRequest paymentRequest) {
        Payment payment = paymentRepository.save(paymentMapper.toPayment(paymentRequest));
        notificationProducer.sendNotification(
                PaymentNotificationRequest.builder()
                        .orderId(payment.getOrderId())
                        .paymentMethod(payment.getPaymentMethod())
                        .amount(paymentRequest.getAmount())
                        .customerResponse(paymentRequest.getCustomerResponse())
                        .build()
        );

        return paymentMapper.toPaymentResponse(payment);
    }
}
