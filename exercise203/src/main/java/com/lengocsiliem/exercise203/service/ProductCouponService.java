package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ProductCoupon;

public interface ProductCouponService {
    List<ProductCoupon> getAllProductCoupons();

    Optional<ProductCoupon> getProductCouponById(UUID id);

    ProductCoupon createProductCoupon(ProductCoupon productCoupon);

    ProductCoupon updateProductCoupon(UUID id, ProductCoupon productCouponDetails);

    void deleteProductCoupon(UUID id);
}
