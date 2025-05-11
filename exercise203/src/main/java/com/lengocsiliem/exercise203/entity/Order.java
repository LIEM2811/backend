package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(length = 50)
    private String id;

    @ManyToOne(cascade = CascadeType.ALL) // Chọn kiểu cascade phù hợp
    @JoinColumn(name = "coupon_id", referencedColumnName = "id", nullable = true)
    private Coupon coupon;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.ALL) // Chọn kiểu cascade phù hợp
    @JoinColumn(name = "order_status_id", referencedColumnName = "id", nullable = true)
    private OrderStatus orderStatus;

    private LocalDateTime orderApprovedAt;
    private LocalDateTime orderDeliveredCarrierDate;
    private LocalDateTime orderDeliveredCustomerDate;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private StaffAccount updatedBy;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getOrderApprovedAt() {
        return orderApprovedAt;
    }

    public void setOrderApprovedAt(LocalDateTime orderApprovedAt) {
        this.orderApprovedAt = orderApprovedAt;
    }

    public LocalDateTime getOrderDeliveredCarrierDate() {
        return orderDeliveredCarrierDate;
    }

    public void setOrderDeliveredCarrierDate(LocalDateTime orderDeliveredCarrierDate) {
        this.orderDeliveredCarrierDate = orderDeliveredCarrierDate;
    }

    public LocalDateTime getOrderDeliveredCustomerDate() {
        return orderDeliveredCustomerDate;
    }

    public void setOrderDeliveredCustomerDate(LocalDateTime orderDeliveredCustomerDate) {
        this.orderDeliveredCustomerDate = orderDeliveredCustomerDate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public StaffAccount getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(StaffAccount updatedBy) {
        this.updatedBy = updatedBy;
    }
}
