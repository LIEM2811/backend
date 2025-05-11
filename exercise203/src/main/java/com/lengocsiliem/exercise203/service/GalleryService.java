package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Gallery;

public interface GalleryService {
    List<Gallery> getAllGallery();

    Gallery getGalleryById(UUID id);

    Gallery createGallery(Gallery gallery);

    Gallery updateGallery(UUID id, Gallery gallery);

    void deleteGallery(UUID id);
}
