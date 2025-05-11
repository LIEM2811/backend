package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
