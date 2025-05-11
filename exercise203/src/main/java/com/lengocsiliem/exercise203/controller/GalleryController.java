package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.Gallery;
import com.lengocsiliem.exercise203.service.GalleryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/gallery")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping
    public List<Gallery> getAllGallery() {
        return galleryService.getAllGallery();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gallery> getGalleryById(@PathVariable UUID id) {
        Gallery gallery = galleryService.getGalleryById(id);
        if (gallery != null) {
            return ResponseEntity.ok(gallery);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Gallery createGallery(@RequestBody Gallery gallery) {
        return galleryService.createGallery(gallery);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gallery> updateGallery(@PathVariable UUID id, @RequestBody Gallery gallery) {
        Gallery updatedGallery = galleryService.updateGallery(id, gallery);
        if (updatedGallery != null) {
            return ResponseEntity.ok(updatedGallery);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGallery(@PathVariable UUID id) {
        galleryService.deleteGallery(id);
        return ResponseEntity.noContent().build();
    }
}
