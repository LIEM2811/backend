package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Notification;

public interface NotificationService {
    List<Notification> getAllNotifications();

    Optional<Notification> getNotificationById(UUID id);

    Notification createNotification(Notification notification);

    Notification updateNotification(UUID id, Notification notificationDetails);

    void deleteNotification(UUID id);
}
