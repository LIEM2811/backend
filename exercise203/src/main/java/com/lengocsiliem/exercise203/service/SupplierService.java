package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Supplier;

public interface SupplierService {
    List<Supplier> findAll();

    Supplier findById(UUID id);

    Supplier save(Supplier supplier);

    Supplier update(UUID id, Supplier supplier);

    void delete(UUID id);
}