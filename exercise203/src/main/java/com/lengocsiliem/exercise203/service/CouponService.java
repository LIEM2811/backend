package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Coupon;

public interface CouponService {
    List<Coupon> getAllCoupons();

    Optional<Coupon> getCouponById(UUID id);

    Coupon createCoupon(Coupon coupon);

    Coupon updateCoupon(UUID id, Coupon couponDetails);

    void deleteCoupon(UUID id);
}
