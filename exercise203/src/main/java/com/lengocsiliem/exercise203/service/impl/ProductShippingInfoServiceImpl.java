package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ProductShippingInfo;
import com.lengocsiliem.exercise203.repository.ProductShippingInfoRepository;
import com.lengocsiliem.exercise203.service.ProductShippingInfoService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductShippingInfoServiceImpl implements ProductShippingInfoService {

    @Autowired
    private ProductShippingInfoRepository productShippingInfoRepository;

    @Override
    public List<ProductShippingInfo> getAllProductShippingInfo() {
        return productShippingInfoRepository.findAll();
    }

    @Override
    public ProductShippingInfo getProductShippingInfoById(UUID id) {
        Optional<ProductShippingInfo> productShippingInfo = productShippingInfoRepository.findById(id);
        return productShippingInfo.orElse(null);
    }

    @Override
    public ProductShippingInfo createProductShippingInfo(ProductShippingInfo productShippingInfo) {
        return productShippingInfoRepository.save(productShippingInfo);
    }

    @Override
    public ProductShippingInfo updateProductShippingInfo(UUID id, ProductShippingInfo productShippingInfo) {
        if (productShippingInfoRepository.existsById(id)) {
            productShippingInfo.setId(id);
            return productShippingInfoRepository.save(productShippingInfo);
        }
        return null;
    }

    @Override
    public void deleteProductShippingInfo(UUID id) {
        productShippingInfoRepository.deleteById(id);
    }
}
