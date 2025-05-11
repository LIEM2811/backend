package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ShippingZone;
import com.lengocsiliem.exercise203.service.ShippingZoneService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shipping-zones")
public class ShippingZoneController {

    @Autowired
    private ShippingZoneService shippingZoneService;

    @GetMapping
    public List<ShippingZone> getAllShippingZones() {
        return shippingZoneService.getAllShippingZones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingZone> getShippingZoneById(@PathVariable UUID id) {
        return shippingZoneService.getShippingZoneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShippingZone createShippingZone(@RequestBody ShippingZone shippingZone) {
        return shippingZoneService.createShippingZone(shippingZone);
    }

    @PutMapping("/{id}")
    public ShippingZone updateShippingZone(@PathVariable UUID id, @RequestBody ShippingZone shippingZone) {
        return shippingZoneService.updateShippingZone(id, shippingZone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingZone(@PathVariable UUID id) {
        shippingZoneService.deleteShippingZone(id);
        return ResponseEntity.noContent().build();
    }
}
