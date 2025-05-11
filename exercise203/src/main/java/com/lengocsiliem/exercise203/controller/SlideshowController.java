package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.Slideshow;
import com.lengocsiliem.exercise203.service.SlideshowService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/slideshows")
public class SlideshowController {

    @Autowired
    private SlideshowService slideshowService;

    @GetMapping
    public List<Slideshow> getAllSlideshows() {
        return slideshowService.getAllSlideshows();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Slideshow> getSlideshowById(@PathVariable UUID id) {
        return slideshowService.getSlideshowById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Slideshow createSlideshow(@RequestBody Slideshow slideshow) {
        return slideshowService.createSlideshow(slideshow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Slideshow> updateSlideshow(@PathVariable UUID id,
            @RequestBody Slideshow slideshowDetails) {
        Slideshow updatedSlideshow = slideshowService.updateSlideshow(id, slideshowDetails);
        return ResponseEntity.ok(updatedSlideshow);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSlideshow(@PathVariable UUID id) {
        slideshowService.deleteSlideshow(id);
        return ResponseEntity.noContent().build();
    }
}
