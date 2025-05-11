package com.lengocsiliem.exercise203.service.impl;

import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Supplier;
import com.lengocsiliem.exercise203.repository.SupplierRepository;
import com.lengocsiliem.exercise203.service.SupplierService;

import java.util.List;
import java.util.UUID;

@Service
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierServiceImpl(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(UUID id) {
        return supplierRepository.findById(id).orElse(null);
    }

    @Override
    public Supplier save(Supplier supplier) {
        return supplierRepository.save(supplier);
    }

    @Override
    public Supplier update(UUID id, Supplier supplier) {
        if (!supplierRepository.existsById(id)) {
            return null; // Or throw an exception
        }
        supplier.setId(id);
        return supplierRepository.save(supplier);
    }

    @Override
    public void delete(UUID id) {
        supplierRepository.deleteById(id);
    }
}
