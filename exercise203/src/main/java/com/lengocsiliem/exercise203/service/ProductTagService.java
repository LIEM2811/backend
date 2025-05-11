package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ProductTag;

public interface ProductTagService {
    List<ProductTag> getAllProductTags();

    Optional<ProductTag> getProductTagById(UUID id);

    ProductTag createProductTag(ProductTag productTag);

    void deleteProductTag(UUID id);
}
