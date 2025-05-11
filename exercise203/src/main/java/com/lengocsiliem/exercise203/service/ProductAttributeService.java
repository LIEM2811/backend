package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ProductAttribute;

public interface ProductAttributeService {
    List<ProductAttribute> getAllProductAttributes();

    ProductAttribute getProductAttributeById(UUID id);

    ProductAttribute createProductAttribute(ProductAttribute productAttribute);

    ProductAttribute updateProductAttribute(UUID id, ProductAttribute productAttribute);

    void deleteProductAttribute(UUID id);
}
