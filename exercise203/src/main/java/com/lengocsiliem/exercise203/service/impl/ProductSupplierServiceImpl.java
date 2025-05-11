package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ProductSupplier;
import com.lengocsiliem.exercise203.repository.ProductSupplierRepository;
import com.lengocsiliem.exercise203.service.ProductSupplierService;

import java.util.List;
import java.util.UUID;

@Service
public class ProductSupplierServiceImpl implements ProductSupplierService {

    @Autowired
    private ProductSupplierRepository productSupplierRepository;

    @Override
    public List<ProductSupplier> findAll() {
        return productSupplierRepository.findAll();
    }

    @Override
    public ProductSupplier findById(UUID id) {
        return productSupplierRepository.findById(id).orElse(null);
    }

    @Override
    public ProductSupplier save(ProductSupplier productSupplier) {
        return productSupplierRepository.save(productSupplier);
    }

    @Override
    public void delete(UUID id) {
        productSupplierRepository.deleteById(id);
    }
}
