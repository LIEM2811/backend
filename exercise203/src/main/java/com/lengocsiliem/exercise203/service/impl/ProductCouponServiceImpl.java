package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ProductCoupon;
import com.lengocsiliem.exercise203.repository.ProductCouponRepository;
import com.lengocsiliem.exercise203.service.ProductCouponService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductCouponServiceImpl implements ProductCouponService {

    @Autowired
    private ProductCouponRepository productCouponRepository;

    @Override
    public List<ProductCoupon> getAllProductCoupons() {
        return productCouponRepository.findAll();
    }

    @Override
    public Optional<ProductCoupon> getProductCouponById(UUID id) {
        return productCouponRepository.findById(id);
    }

    @Override
    public ProductCoupon createProductCoupon(ProductCoupon productCoupon) {
        return productCouponRepository.save(productCoupon);
    }

    @Override
    public ProductCoupon updateProductCoupon(UUID id, ProductCoupon productCouponDetails) {
        ProductCoupon productCoupon = productCouponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProductCoupon not found"));
        productCoupon.setProduct(productCouponDetails.getProduct());
        productCoupon.setCoupon(productCouponDetails.getCoupon());
        return productCouponRepository.save(productCoupon);
    }

    @Override
    public void deleteProductCoupon(UUID id) {
        productCouponRepository.deleteById(id);
    }
}
