package com.lengocsiliem.exercise203.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.Variant;
import com.lengocsiliem.exercise203.service.VariantService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/variants")
public class VariantController {

    private final VariantService variantService;

    // Remove the @Autowired annotation
    public VariantController(VariantService variantService) {
        this.variantService = variantService;
    }

    @PostMapping
    public ResponseEntity<Variant> createVariant(@RequestBody Variant variant) {
        Variant createdVariant = variantService.createVariant(variant);
        return new ResponseEntity<>(createdVariant, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variant> getVariantById(@PathVariable UUID id) {
        Variant variant = variantService.getVariantById(id);
        return variant != null ? ResponseEntity.ok(variant) : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Variant>> getAllVariants() {
        List<Variant> variants = variantService.getAllVariants();
        return ResponseEntity.ok(variants);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Variant> updateVariant(@PathVariable UUID id, @RequestBody Variant variant) {
        Variant updatedVariant = variantService.updateVariant(id, variant);
        return updatedVariant != null ? ResponseEntity.ok(updatedVariant) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable UUID id) {
        variantService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }
}
