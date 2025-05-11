package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.AttributeValue;

import java.util.UUID;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, UUID> {
}
