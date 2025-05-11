package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.ShippingZone;
import com.lengocsiliem.exercise203.repository.ShippingZoneRepository;
import com.lengocsiliem.exercise203.service.ShippingZoneService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ShippingZoneServiceImpl implements ShippingZoneService {

    @Autowired
    private ShippingZoneRepository shippingZoneRepository;

    @Override
    public List<ShippingZone> getAllShippingZones() {
        return shippingZoneRepository.findAll();
    }

    @Override
    public Optional<ShippingZone> getShippingZoneById(UUID id) {
        return shippingZoneRepository.findById(id);
    }

    @Override
    public ShippingZone createShippingZone(ShippingZone shippingZone) {
        return shippingZoneRepository.save(shippingZone);
    }

    @Override
    public ShippingZone updateShippingZone(UUID id, ShippingZone shippingZoneDetails) {
        ShippingZone shippingZone = shippingZoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping Zone not found"));
        shippingZone.setName(shippingZoneDetails.getName());
        shippingZone.setDisplayName(shippingZoneDetails.getDisplayName());
        shippingZone.setActive(shippingZoneDetails.getActive());
        shippingZone.setFreeShipping(shippingZoneDetails.getFreeShipping());
        shippingZone.setRateType(shippingZoneDetails.getRateType());
        shippingZone.setUpdatedAt(LocalDateTime.now()); // Đã thêm LocalDateTime ở đây
        shippingZone.setUpdatedBy(shippingZoneDetails.getUpdatedBy()); // Assuming you're passing updatedBy as part of
                                                                       // the request
        return shippingZoneRepository.save(shippingZone);
    }

    @Override
    public void deleteShippingZone(UUID id) {
        shippingZoneRepository.deleteById(id);
    }
}
