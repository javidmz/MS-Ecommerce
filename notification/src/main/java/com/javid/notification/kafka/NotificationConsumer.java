package com.javid.notification.kafka;

import com.javid.notification.controller.NotificationRequest;
import com.javid.notification.email.EmailService;
import com.javid.notification.entity.Notification;
import com.javid.notification.kafka.order.OrderConfirmation;
import com.javid.notification.kafka.payment.PaymentConfirmation;
import com.javid.notification.repository.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.javid.notification.entity.NotificationType.ORDER_CONFIRMATION;
import static com.javid.notification.entity.NotificationType.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment-topic", groupId = "notificationGroup")
    public void listenPaymentConfirmation(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Received payment confirmation: {}", paymentConfirmation);
        notificationRepository.save(
                Notification.builder()
                        .notificationType(PAYMENT_CONFIRMATION)
                        .localDateTime(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        emailService.sendPaymentConfirmationEmail(
                paymentConfirmation.getCustomerResponse().getEmail(),
                paymentConfirmation.getCustomerResponse().getFirstName(),
                paymentConfirmation.getAmount()
        );
    }

    @KafkaListener(topics = "order-topic", groupId = "notificationGroup")
    public void listenOrderConfirmation(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Received order confirmation: {}", orderConfirmation.toString());
        notificationRepository.save(
                Notification.builder()
                        .notificationType(ORDER_CONFIRMATION)
                        .localDateTime(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        emailService.sendOrderConfirmationEmail(
                orderConfirmation.getCustomerResponse().getEmail(),
                orderConfirmation.getCustomerResponse().getFirstName(),
                orderConfirmation.getTotalPrice(),
                orderConfirmation.getProductOrderRequests()
        );
    }

    public void saveNotification(NotificationRequest notification) {
        notificationRepository.save(
                Notification.builder()
                        .notificationType(notification.getNotificationType())
                        .localDateTime(LocalDateTime.now())
                        .build()
        );
    }
}
