package com.javid.notification.controller;

import com.javid.notification.entity.NotificationType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {
    private NotificationType notificationType;
}
