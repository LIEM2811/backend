package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Notification;
import com.lengocsiliem.exercise203.repository.NotificationRepository;
import com.lengocsiliem.exercise203.service.NotificationService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(UUID id) {
        return notificationRepository.findById(id);
    }

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification updateNotification(UUID id, Notification notificationDetails) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setTitle(notificationDetails.getTitle());
        notification.setContent(notificationDetails.getContent());
        notification.setSeen(notificationDetails.getSeen());
        notification.setReceiveTime(notificationDetails.getReceiveTime());
        notification.setNotificationExpiryDate(notificationDetails.getNotificationExpiryDate());
        return notificationRepository.save(notification);
    }

    @Override
    public void deleteNotification(UUID id) {
        notificationRepository.deleteById(id);
    }
}
