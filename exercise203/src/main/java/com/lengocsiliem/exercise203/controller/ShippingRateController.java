package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.ShippingRate;
import com.lengocsiliem.exercise203.service.ShippingRateService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shipping-rates")
public class ShippingRateController {

    @Autowired
    private ShippingRateService shippingRateService;

    @GetMapping
    public List<ShippingRate> getAllShippingRates() {
        return shippingRateService.getAllShippingRates();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingRate> getShippingRateById(@PathVariable UUID id) {
        return shippingRateService.getShippingRateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ShippingRate createShippingRate(@RequestBody ShippingRate shippingRate) {
        return shippingRateService.createShippingRate(shippingRate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingRate> updateShippingRate(@PathVariable UUID id,
            @RequestBody ShippingRate shippingRateDetails) {
        ShippingRate updatedShippingRate = shippingRateService.updateShippingRate(id, shippingRateDetails);
        return ResponseEntity.ok(updatedShippingRate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingRate(@PathVariable UUID id) {
        shippingRateService.deleteShippingRate(id);
        return ResponseEntity.noContent().build();
    }
}
