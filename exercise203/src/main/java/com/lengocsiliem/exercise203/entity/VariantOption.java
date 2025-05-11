package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "variant_options")
public class VariantOption {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Gallery image;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Double salePrice;

    @Column
    private Double comparePrice;

    @Column
    private Double buyingPrice;

    @Column(nullable = false)
    private Integer quantity;

    @Column
    private String sku;

    @Column
    private Boolean active = true;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Gallery getImage() {
        return image;
    }

    public void setImage(Gallery image) {
        this.image = image;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Double getComparePrice() {
        return comparePrice;
    }

    public void setComparePrice(Double comparePrice) {
        this.comparePrice = comparePrice;
    }

    public Double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(Double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
