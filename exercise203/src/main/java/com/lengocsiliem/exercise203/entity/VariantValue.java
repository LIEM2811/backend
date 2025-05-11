package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "variant_values")
public class VariantValue {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "variant_id", nullable = false)
    private Variant variant;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_attribute_value_id", nullable = false)
    private ProductAttributeValue productAttributeValue;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Variant getVariant() {
        return variant;
    }

    public void setVariant(Variant variant) {
        this.variant = variant;
    }

    public ProductAttributeValue getProductAttributeValue() {
        return productAttributeValue;
    }

    public void setProductAttributeValue(ProductAttributeValue productAttributeValue) {
        this.productAttributeValue = productAttributeValue;
    }
}
