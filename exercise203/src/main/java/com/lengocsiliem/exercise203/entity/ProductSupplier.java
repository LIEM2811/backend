package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product_suppliers")
public class ProductSupplier {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    // Constructors, getters, and setters
    public ProductSupplier() {
    }

    public ProductSupplier(Product product, Supplier supplier) {
        this.product = product;
        this.supplier = supplier;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}