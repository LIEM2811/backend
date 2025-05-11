package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.Attribute;

import java.util.UUID;

public interface AttributeRepository extends JpaRepository<Attribute, UUID> {
}
