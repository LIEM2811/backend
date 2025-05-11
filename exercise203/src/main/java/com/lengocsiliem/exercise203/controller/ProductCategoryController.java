package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ProductCategory;
import com.lengocsiliem.exercise203.service.ProductCategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryService.getAllProductCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable UUID id) {
        ProductCategory productCategory = productCategoryService.getProductCategoryById(id);
        if (productCategory != null) {
            return ResponseEntity.ok(productCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ProductCategory createProductCategory(@RequestBody ProductCategory productCategory) {
        return productCategoryService.createProductCategory(productCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable UUID id,
            @RequestBody ProductCategory productCategory) {
        ProductCategory updatedProductCategory = productCategoryService.updateProductCategory(id, productCategory);
        if (updatedProductCategory != null) {
            return ResponseEntity.ok(updatedProductCategory);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable UUID id) {
        productCategoryService.deleteProductCategory(id);
        return ResponseEntity.noContent().build();
    }
}
