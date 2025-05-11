package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ProductCoupon;
import com.lengocsiliem.exercise203.service.ProductCouponService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-coupons")
public class ProductCouponController {

    @Autowired
    private ProductCouponService productCouponService;

    @GetMapping
    public List<ProductCoupon> getAllProductCoupons() {
        return productCouponService.getAllProductCoupons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCoupon> getProductCouponById(@PathVariable UUID id) {
        return productCouponService.getProductCouponById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ProductCoupon createProductCoupon(@RequestBody ProductCoupon productCoupon) {
        return productCouponService.createProductCoupon(productCoupon);
    }

    @PutMapping("/{id}")
    public ProductCoupon updateProductCoupon(@PathVariable UUID id, @RequestBody ProductCoupon productCoupon) {
        return productCouponService.updateProductCoupon(id, productCoupon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCoupon(@PathVariable UUID id) {
        productCouponService.deleteProductCoupon(id);
        return ResponseEntity.noContent().build();
    }
}
