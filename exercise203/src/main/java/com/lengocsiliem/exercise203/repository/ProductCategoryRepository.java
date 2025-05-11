package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.ProductCategory;

import java.util.UUID;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, UUID> {
}
