package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lengocsiliem.exercise203.entity.Coupon;

import java.util.UUID;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, UUID> {
    Coupon findByCode(String code);
}
