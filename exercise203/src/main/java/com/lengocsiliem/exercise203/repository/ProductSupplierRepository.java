package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lengocsiliem.exercise203.entity.ProductSupplier;

import java.util.UUID;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, UUID> {
}
