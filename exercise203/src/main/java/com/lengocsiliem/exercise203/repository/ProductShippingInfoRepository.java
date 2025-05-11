package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.ProductShippingInfo;

import java.util.UUID;

public interface ProductShippingInfoRepository extends JpaRepository<ProductShippingInfo, UUID> {
}
