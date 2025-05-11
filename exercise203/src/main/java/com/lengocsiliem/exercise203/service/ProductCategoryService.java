package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ProductCategory;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();

    ProductCategory getProductCategoryById(UUID id);

    ProductCategory createProductCategory(ProductCategory productCategory);

    ProductCategory updateProductCategory(UUID id, ProductCategory productCategory);

    void deleteProductCategory(UUID id);
}
