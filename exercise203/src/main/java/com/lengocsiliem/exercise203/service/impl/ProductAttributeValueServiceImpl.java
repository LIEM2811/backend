package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ProductAttributeValue;
import com.lengocsiliem.exercise203.repository.ProductAttributeValueRepository;
import com.lengocsiliem.exercise203.service.ProductAttributeValueService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductAttributeValueServiceImpl implements ProductAttributeValueService {

    @Autowired
    private ProductAttributeValueRepository productAttributeValueRepository;

    @Override
    public List<ProductAttributeValue> getAllProductAttributeValues() {
        return productAttributeValueRepository.findAll();
    }

    @Override
    public ProductAttributeValue getProductAttributeValueById(UUID id) {
        Optional<ProductAttributeValue> productAttributeValue = productAttributeValueRepository.findById(id);
        return productAttributeValue.orElse(null);
    }

    @Override
    public ProductAttributeValue createProductAttributeValue(ProductAttributeValue productAttributeValue) {
        return productAttributeValueRepository.save(productAttributeValue);
    }

    @Override
    public ProductAttributeValue updateProductAttributeValue(UUID id, ProductAttributeValue productAttributeValue) {
        if (productAttributeValueRepository.existsById(id)) {
            productAttributeValue.setId(id);
            return productAttributeValueRepository.save(productAttributeValue);
        }
        return null;
    }

    @Override
    public void deleteProductAttributeValue(UUID id) {
        productAttributeValueRepository.deleteById(id);
    }
}
