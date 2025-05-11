package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.VariantOption;

import java.util.UUID;

public interface VariantOptionRepository extends JpaRepository<VariantOption, UUID> {
}
