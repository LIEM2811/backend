package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ProductTag;
import com.lengocsiliem.exercise203.service.ProductTagService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-tags")
public class ProductTagController {

    @Autowired
    private ProductTagService productTagService;

    @GetMapping
    public List<ProductTag> getAllProductTags() {
        return productTagService.getAllProductTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductTag> getProductTagById(@PathVariable UUID id) {
        Optional<ProductTag> productTag = productTagService.getProductTagById(id);
        return productTag.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductTag createProductTag(@RequestBody ProductTag productTag) {
        return productTagService.createProductTag(productTag);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductTag(@PathVariable UUID id) {
        productTagService.deleteProductTag(id);
        return ResponseEntity.noContent().build();
    }
}
