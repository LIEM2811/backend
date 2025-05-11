package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Slideshow;

public interface SlideshowService {
    List<Slideshow> getAllSlideshows();

    Optional<Slideshow> getSlideshowById(UUID id);

    Slideshow createSlideshow(Slideshow slideshow);

    Slideshow updateSlideshow(UUID id, Slideshow slideshowDetails);

    void deleteSlideshow(UUID id);
}
