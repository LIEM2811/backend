package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ShippingRate;

public interface ShippingRateService {
    List<ShippingRate> getAllShippingRates();

    Optional<ShippingRate> getShippingRateById(UUID id);

    ShippingRate createShippingRate(ShippingRate shippingRate);

    ShippingRate updateShippingRate(UUID id, ShippingRate shippingRateDetails);

    void deleteShippingRate(UUID id);
}
