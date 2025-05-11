package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ProductShippingInfo;

public interface ProductShippingInfoService {
    List<ProductShippingInfo> getAllProductShippingInfo();

    ProductShippingInfo getProductShippingInfoById(UUID id);

    ProductShippingInfo createProductShippingInfo(ProductShippingInfo productShippingInfo);

    ProductShippingInfo updateProductShippingInfo(UUID id, ProductShippingInfo productShippingInfo);

    void deleteProductShippingInfo(UUID id);
}
