package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ProductAttributeValue;

public interface ProductAttributeValueService {
    List<ProductAttributeValue> getAllProductAttributeValues();

    ProductAttributeValue getProductAttributeValueById(UUID id);

    ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue);

    ProductAttributeValue updateProductAttributeValue(UUID id, ProductAttributeValue productAttributeValue);

    void deleteProductAttributeValue(UUID id);
}
