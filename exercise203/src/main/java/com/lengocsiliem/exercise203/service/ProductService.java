package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Product;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(UUID id); // Đây là phương thức đã được định nghĩa

    Product createProduct(Product product);

    Product updateProduct(UUID id, Product product);

    void deleteProduct(UUID id);
}