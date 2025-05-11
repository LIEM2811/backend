package com.lengocsiliem.exercise203.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lengocsiliem.exercise203.entity.Gallery;

import java.util.UUID;

public interface GalleryRepository extends JpaRepository<Gallery, UUID> {
}
