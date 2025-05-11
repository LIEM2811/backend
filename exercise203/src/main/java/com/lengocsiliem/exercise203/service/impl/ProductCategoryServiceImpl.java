package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ProductCategory;
import com.lengocsiliem.exercise203.repository.ProductCategoryRepository;
import com.lengocsiliem.exercise203.service.ProductCategoryService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getProductCategoryById(UUID id) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findById(id);
        return productCategory.orElse(null);
    }

    @Override
    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(UUID id, ProductCategory productCategory) {
        if (productCategoryRepository.existsById(id)) {
            productCategory.setId(id);
            return productCategoryRepository.save(productCategory);
        }
        return null;
    }

    @Override
    public void deleteProductCategory(UUID id) {
        productCategoryRepository.deleteById(id);
    }
}
