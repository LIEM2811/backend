package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "variants")
public class Variant {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String variantOption;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name = "variant_option_id", nullable = false)
    private VariantOption variantOptionId;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVariantOption() {
        return variantOption;
    }

    public void setVariantOption(String variantOption) {
        this.variantOption = variantOption;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public VariantOption getVariantOptionId() {
        return variantOptionId;
    }

    public void setVariantOptionId(VariantOption variantOptionId) {
        this.variantOptionId = variantOptionId;
    }
}
