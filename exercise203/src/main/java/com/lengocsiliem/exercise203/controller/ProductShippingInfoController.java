package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ProductShippingInfo;
import com.lengocsiliem.exercise203.service.ProductShippingInfoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-shipping-info")
public class ProductShippingInfoController {

    @Autowired
    private ProductShippingInfoService productShippingInfoService;

    @GetMapping
    public List<ProductShippingInfo> getAllProductShippingInfo() {
        return productShippingInfoService.getAllProductShippingInfo();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductShippingInfo> getProductShippingInfoById(@PathVariable UUID id) {
        ProductShippingInfo productShippingInfo = productShippingInfoService.getProductShippingInfoById(id);
        if (productShippingInfo != null) {
            return ResponseEntity.ok(productShippingInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ProductShippingInfo createProductShippingInfo(@RequestBody ProductShippingInfo productShippingInfo) {
        return productShippingInfoService.createProductShippingInfo(productShippingInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductShippingInfo> updateProductShippingInfo(@PathVariable UUID id,
            @RequestBody ProductShippingInfo productShippingInfo) {
        ProductShippingInfo updatedProductShippingInfo = productShippingInfoService.updateProductShippingInfo(id,
                productShippingInfo);
        if (updatedProductShippingInfo != null) {
            return ResponseEntity.ok(updatedProductShippingInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductShippingInfo(@PathVariable UUID id) {
        productShippingInfoService.deleteProductShippingInfo(id);
        return ResponseEntity.noContent().build();
    }
}
