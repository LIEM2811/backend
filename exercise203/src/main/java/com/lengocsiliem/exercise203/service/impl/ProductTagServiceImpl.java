package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ProductTag;
import com.lengocsiliem.exercise203.repository.ProductTagRepository;
import com.lengocsiliem.exercise203.service.ProductTagService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductTagServiceImpl implements ProductTagService {

    @Autowired
    private ProductTagRepository productTagRepository;

    @Override
    public List<ProductTag> getAllProductTags() {
        return productTagRepository.findAll();
    }

    @Override
    public Optional<ProductTag> getProductTagById(UUID id) {
        return productTagRepository.findById(id);
    }

    @Override
    public ProductTag createProductTag(ProductTag productTag) {
        return productTagRepository.save(productTag);
    }

    @Override
    public void deleteProductTag(UUID id) {
        productTagRepository.deleteById(id);
    }
}
