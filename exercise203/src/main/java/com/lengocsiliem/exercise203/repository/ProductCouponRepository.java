package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lengocsiliem.exercise203.entity.ProductCoupon;

import java.util.UUID;

@Repository
public interface ProductCouponRepository extends JpaRepository<ProductCoupon, UUID> {

}
