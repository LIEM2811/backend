package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ProductSupplier;
import com.lengocsiliem.exercise203.service.ProductSupplierService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-suppliers")
public class ProductSupplierController {

    @Autowired
    private ProductSupplierService productSupplierService;

    @GetMapping
    public List<ProductSupplier> getAllProductSuppliers() {
        return productSupplierService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductSupplier> getProductSupplierById(@PathVariable UUID id) {
        ProductSupplier productSupplier = productSupplierService.findById(id);
        return ResponseEntity.ok(productSupplier);
    }

    @PostMapping
    public ResponseEntity<ProductSupplier> createProductSupplier(@RequestBody ProductSupplier productSupplier) {
        ProductSupplier createdProductSupplier = productSupplierService.save(productSupplier);
        return ResponseEntity.ok(createdProductSupplier);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductSupplier(@PathVariable UUID id) {
        productSupplierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
