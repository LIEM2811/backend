package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ProductAttribute;
import com.lengocsiliem.exercise203.service.ProductAttributeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-attributes")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @GetMapping
    public List<ProductAttribute> getAllProductAttributes() {
        return productAttributeService.getAllProductAttributes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductAttribute> getProductAttributeById(@PathVariable UUID id) {
        ProductAttribute productAttribute = productAttributeService.getProductAttributeById(id);
        if (productAttribute != null) {
            return ResponseEntity.ok(productAttribute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ProductAttribute createProductAttribute(@RequestBody ProductAttribute productAttribute) {
        return productAttributeService.createProductAttribute(productAttribute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttribute> updateProductAttribute(@PathVariable UUID id,
            @RequestBody ProductAttribute productAttribute) {
        ProductAttribute updatedProductAttribute = productAttributeService.updateProductAttribute(id, productAttribute);
        if (updatedProductAttribute != null) {
            return ResponseEntity.ok(updatedProductAttribute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductAttribute(@PathVariable UUID id) {
        productAttributeService.deleteProductAttribute(id);
        return ResponseEntity.noContent().build();
    }
}
