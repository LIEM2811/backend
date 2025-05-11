package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ShippingRate;
import com.lengocsiliem.exercise203.repository.ShippingRateRepository;
import com.lengocsiliem.exercise203.service.ShippingRateService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShippingRateServiceImpl implements ShippingRateService {

    @Autowired
    private ShippingRateRepository shippingRateRepository;

    @Override
    public List<ShippingRate> getAllShippingRates() {
        return shippingRateRepository.findAll();
    }

    @Override
    public Optional<ShippingRate> getShippingRateById(UUID id) {
        return shippingRateRepository.findById(id);
    }

    @Override
    public ShippingRate createShippingRate(ShippingRate shippingRate) {
        return shippingRateRepository.save(shippingRate);
    }

    @Override
    public ShippingRate updateShippingRate(UUID id, ShippingRate shippingRateDetails) {
        ShippingRate shippingRate = shippingRateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping Rate not found"));
        shippingRate.setShippingZone(shippingRateDetails.getShippingZone());
        shippingRate.setWeightUnit(shippingRateDetails.getWeightUnit());
        shippingRate.setMinValue(shippingRateDetails.getMinValue());
        shippingRate.setMaxValue(shippingRateDetails.getMaxValue());
        shippingRate.setNoMax(shippingRateDetails.getNoMax());
        shippingRate.setPrice(shippingRateDetails.getPrice());
        return shippingRateRepository.save(shippingRate);
    }

    @Override
    public void deleteShippingRate(UUID id) {
        shippingRateRepository.deleteById(id);
    }
}
