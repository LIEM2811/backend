package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.ShippingZone;

public interface ShippingZoneService {
    List<ShippingZone> getAllShippingZones();

    Optional<ShippingZone> getShippingZoneById(UUID id);

    ShippingZone createShippingZone(ShippingZone shippingZone);

    ShippingZone updateShippingZone(UUID id, ShippingZone shippingZoneDetails);

    void deleteShippingZone(UUID id);
}
