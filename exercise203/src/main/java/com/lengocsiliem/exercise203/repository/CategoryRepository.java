package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.Category;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
}
