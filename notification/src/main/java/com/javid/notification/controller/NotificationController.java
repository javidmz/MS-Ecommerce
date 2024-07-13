package com.javid.notification.controller;

import com.javid.notification.kafka.NotificationConsumer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/notification")
public class NotificationController {
    private final NotificationConsumer notificationConsumer;

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notification) {
        notificationConsumer.saveNotification(notification);
    }
}
