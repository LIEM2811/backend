package com.lengocsiliem.exercise203.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "product_shipping_info")
public class ProductShippingInfo {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @Column(nullable = false)
    private BigDecimal weight = BigDecimal.ZERO;

    @Column(nullable = false)
    private String weightUnit;

    @Column(nullable = false)
    private BigDecimal volume = BigDecimal.ZERO;

    @Column(nullable = false)
    private String volumeUnit;

    @Column(nullable = false)
    private BigDecimal dimensionWidth = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal dimensionHeight = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal dimensionDepth = BigDecimal.ZERO;

    @Column(nullable = false)
    private String dimensionUnit;

    // Getters and Setters
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public String getVolumeUnit() {
        return volumeUnit;
    }

    public void setVolumeUnit(String volumeUnit) {
        this.volumeUnit = volumeUnit;
    }

    public BigDecimal getDimensionWidth() {
        return dimensionWidth;
    }

    public void setDimensionWidth(BigDecimal dimensionWidth) {
        this.dimensionWidth = dimensionWidth;
    }

    public BigDecimal getDimensionHeight() {
        return dimensionHeight;
    }

    public void setDimensionHeight(BigDecimal dimensionHeight) {
        this.dimensionHeight = dimensionHeight;
    }

    public BigDecimal getDimensionDepth() {
        return dimensionDepth;
    }

    public void setDimensionDepth(BigDecimal dimensionDepth) {
        this.dimensionDepth = dimensionDepth;
    }

    public String getDimensionUnit() {
        return dimensionUnit;
    }

    public void setDimensionUnit(String dimensionUnit) {
        this.dimensionUnit = dimensionUnit;
    }
}
