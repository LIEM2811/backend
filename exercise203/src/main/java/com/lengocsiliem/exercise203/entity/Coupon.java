package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column
    private Double discountValue;

    @Column(nullable = false)
    private String discountType;

    @Column(nullable = false)
    private Integer timesUsed = 0;

    @Column
    private Integer maxUsage;

    @Column
    private Double orderAmountLimit;

    @Column
    private OffsetDateTime couponStartDate;

    @Column
    private OffsetDateTime couponEndDate;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Integer getTimesUsed() {
        return timesUsed;
    }

    public void setTimesUsed(Integer timesUsed) {
        this.timesUsed = timesUsed;
    }

    public Integer getMaxUsage() {
        return maxUsage;
    }

    public void setMaxUsage(Integer maxUsage) {
        this.maxUsage = maxUsage;
    }

    public Double getOrderAmountLimit() {
        return orderAmountLimit;
    }

    public void setOrderAmountLimit(Double orderAmountLimit) {
        this.orderAmountLimit = orderAmountLimit;
    }

    public OffsetDateTime getCouponStartDate() {
        return couponStartDate;
    }

    public void setCouponStartDate(OffsetDateTime couponStartDate) {
        this.couponStartDate = couponStartDate;
    }

    public OffsetDateTime getCouponEndDate() {
        return couponEndDate;
    }

    public void setCouponEndDate(OffsetDateTime couponEndDate) {
        this.couponEndDate = couponEndDate;
    }
}
