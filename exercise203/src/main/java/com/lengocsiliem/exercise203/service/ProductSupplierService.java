package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ProductSupplier;

public interface ProductSupplierService {
    List<ProductSupplier> findAll();

    ProductSupplier findById(UUID id);

    ProductSupplier save(ProductSupplier productSupplier);

    void delete(UUID id);
}
