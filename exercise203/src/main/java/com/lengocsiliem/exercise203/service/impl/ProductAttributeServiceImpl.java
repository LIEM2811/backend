package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ProductAttribute;
import com.lengocsiliem.exercise203.repository.ProductAttributeRepository;
import com.lengocsiliem.exercise203.service.ProductAttributeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {

    @Autowired
    private ProductAttributeRepository productAttributeRepository;

    @Override
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeRepository.findAll();
    }

    @Override
    public ProductAttribute getProductAttributeById(UUID id) {
        Optional<ProductAttribute> productAttribute = productAttributeRepository.findById(id);
        return productAttribute.orElse(null);
    }

    @Override
    public ProductAttribute createProductAttribute(ProductAttribute productAttribute) {
        return productAttributeRepository.save(productAttribute);
    }

    @Override
    public ProductAttribute updateProductAttribute(UUID id, ProductAttribute productAttribute) {
        if (productAttributeRepository.existsById(id)) {
            productAttribute.setId(id);
            return productAttributeRepository.save(productAttribute);
        }
        return null;
    }

    @Override
    public void deleteProductAttribute(UUID id) {
        productAttributeRepository.deleteById(id);
    }
}
