package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Gallery;
import com.lengocsiliem.exercise203.repository.GalleryRepository;
import com.lengocsiliem.exercise203.service.GalleryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public List<Gallery> getAllGallery() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery getGalleryById(UUID id) {
        Optional<Gallery> gallery = galleryRepository.findById(id);
        return gallery.orElse(null);
    }

    @Override
    public Gallery createGallery(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    @Override
    public Gallery updateGallery(UUID id, Gallery gallery) {
        if (galleryRepository.existsById(id)) {
            gallery.setId(id);
            return galleryRepository.save(gallery);
        }
        return null;
    }

    @Override
    public void deleteGallery(UUID id) {
        galleryRepository.deleteById(id);
    }
}
