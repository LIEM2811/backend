package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.CardItem;

import java.util.UUID;

public interface CardItemRepository extends JpaRepository<CardItem, UUID> {
}
