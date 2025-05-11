package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Coupon;
import com.lengocsiliem.exercise203.repository.CouponRepository;
import com.lengocsiliem.exercise203.service.CouponService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CouponServiceImpl implements CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Optional<Coupon> getCouponById(UUID id) {
        return couponRepository.findById(id);
    }

    @Override
    public Coupon createCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon updateCoupon(UUID id, Coupon couponDetails) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));
        coupon.setCode(couponDetails.getCode());
        coupon.setDiscountValue(couponDetails.getDiscountValue());
        coupon.setDiscountType(couponDetails.getDiscountType());
        coupon.setTimesUsed(couponDetails.getTimesUsed());
        coupon.setMaxUsage(couponDetails.getMaxUsage());
        coupon.setOrderAmountLimit(couponDetails.getOrderAmountLimit());
        coupon.setCouponStartDate(couponDetails.getCouponStartDate());
        coupon.setCouponEndDate(couponDetails.getCouponEndDate());
        return couponRepository.save(coupon);
    }

    @Override
    public void deleteCoupon(UUID id) {
        couponRepository.deleteById(id);
    }
}
