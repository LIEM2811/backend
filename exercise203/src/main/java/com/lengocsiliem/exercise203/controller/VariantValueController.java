package com.lengocsiliem.exercise203.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.VariantValue;
import com.lengocsiliem.exercise203.service.VariantValueService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/variant-values")
public class VariantValueController {

    private final VariantValueService variantValueService;

    public VariantValueController(VariantValueService variantValueService) {
        this.variantValueService = variantValueService;
    }

    @PostMapping
    public ResponseEntity<VariantValue> createVariantValue(@RequestBody VariantValue variantValue) {
        VariantValue createdVariantValue = variantValueService.createVariantValue(variantValue);
        return new ResponseEntity<>(createdVariantValue, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VariantValue> getVariantValueById(@PathVariable UUID id) {
        VariantValue variantValue = variantValueService.getVariantValueById(id);
        return variantValue != null ? ResponseEntity.ok(variantValue) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<VariantValue>> getAllVariantValues() {
        List<VariantValue> variantValues = variantValueService.getAllVariantValues();
        return ResponseEntity.ok(variantValues);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VariantValue> updateVariantValue(@PathVariable UUID id,
            @RequestBody VariantValue variantValue) {
        VariantValue updatedVariantValue = variantValueService.updateVariantValue(id, variantValue);
        return updatedVariantValue != null ? ResponseEntity.ok(updatedVariantValue) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariantValue(@PathVariable UUID id) {
        variantValueService.deleteVariantValue(id);
        return ResponseEntity.noContent().build();
    }
}
