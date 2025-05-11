package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "notifications")
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private StaffAccount accountId;

    private String title;

    private String content;

    private Boolean seen;

    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt = OffsetDateTime.now();

    private OffsetDateTime receiveTime;

    private java.time.LocalDate notificationExpiryDate;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public StaffAccount getAccountId() {
        return accountId;
    }

    public void setAccountId(StaffAccount accountId) {
        this.accountId = accountId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getSeen() {
        return seen;
    }

    public void setSeen(Boolean seen) {
        this.seen = seen;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(OffsetDateTime receiveTime) {
        this.receiveTime = receiveTime;
    }

    public java.time.LocalDate getNotificationExpiryDate() {
        return notificationExpiryDate;
    }

    public void setNotificationExpiryDate(java.time.LocalDate notificationExpiryDate) {
        this.notificationExpiryDate = notificationExpiryDate;
    }
}
