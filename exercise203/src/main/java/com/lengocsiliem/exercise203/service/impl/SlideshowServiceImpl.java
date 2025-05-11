package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Slideshow;
import com.lengocsiliem.exercise203.repository.SlideshowRepository;
import com.lengocsiliem.exercise203.service.SlideshowService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SlideshowServiceImpl implements SlideshowService {

    @Autowired
    private SlideshowRepository slideshowRepository;

    @Override
    public List<Slideshow> getAllSlideshows() {
        return slideshowRepository.findAll();
    }

    @Override
    public Optional<Slideshow> getSlideshowById(UUID id) {
        return slideshowRepository.findById(id);
    }

    @Override
    public Slideshow createSlideshow(Slideshow slideshow) {
        return slideshowRepository.save(slideshow);
    }

    @Override
    public Slideshow updateSlideshow(UUID id, Slideshow slideshowDetails) {
        Slideshow slideshow = slideshowRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slideshow not found"));
        slideshow.setTitle(slideshowDetails.getTitle());
        slideshow.setDestinationUrl(slideshowDetails.getDestinationUrl());
        slideshow.setImage(slideshowDetails.getImage());
        slideshow.setPlaceholder(slideshowDetails.getPlaceholder());
        slideshow.setDescription(slideshowDetails.getDescription());
        slideshow.setBtnLabel(slideshowDetails.getBtnLabel());
        slideshow.setDisplayOrder(slideshowDetails.getDisplayOrder());
        slideshow.setPublished(slideshowDetails.getPublished());
        slideshow.setClicks(slideshowDetails.getClicks());
        slideshow.setStyles(slideshowDetails.getStyles());
        slideshow.setUpdatedAt(java.time.OffsetDateTime.now());
        slideshow.setUpdatedBy(slideshowDetails.getUpdatedBy()); // Assuming you're passing updatedBy as part of the
                                                                 // request
        return slideshowRepository.save(slideshow);
    }

    @Override
    public void deleteSlideshow(UUID id) {
        slideshowRepository.deleteById(id);
    }
}
