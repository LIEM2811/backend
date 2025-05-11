package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ProductAttributeValue;
import com.lengocsiliem.exercise203.service.ProductAttributeValueService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-attribute-values")
public class ProductAttributeValueController {

    @Autowired
    private ProductAttributeValueService productAttributeValueService;

    @GetMapping
    public List<ProductAttributeValue> getAllProductAttributeValues() {
        return productAttributeValueService.getAllProductAttributeValues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductAttributeValue> getProductAttributeValueById(@PathVariable UUID id) {
        ProductAttributeValue productAttributeValue = productAttributeValueService.getProductAttributeValueById(id);
        if (productAttributeValue != null) {
            return ResponseEntity.ok(productAttributeValue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ProductAttributeValue createProductAttributeValue(@RequestBody ProductAttributeValue productAttributeValue) {
        return productAttributeValueService.createProductAttributeValue(productAttributeValue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttributeValue> updateProductAttributeValue(@PathVariable UUID id,
            @RequestBody ProductAttributeValue productAttributeValue) {
        ProductAttributeValue updatedProductAttributeValue = productAttributeValueService
                .updateProductAttributeValue(id, productAttributeValue);
        if (updatedProductAttributeValue != null) {
            return ResponseEntity.ok(updatedProductAttributeValue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductAttributeValue(@PathVariable UUID id) {
        productAttributeValueService.deleteProductAttributeValue(id);
        return ResponseEntity.noContent().build();
    }
}
