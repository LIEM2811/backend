package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.VariantOption;
import com.lengocsiliem.exercise203.service.VariantOptionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/variant-options")
public class VariantOptionController {

    @Autowired
    private VariantOptionService variantOptionService;

    @GetMapping
    public List<VariantOption> getAllVariantOptions() {
        return variantOptionService.getAllVariantOptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VariantOption> getVariantOptionById(@PathVariable UUID id) {
        VariantOption variantOption = variantOptionService.getVariantOptionById(id);
        if (variantOption != null) {
            return ResponseEntity.ok(variantOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public VariantOption createVariantOption(@RequestBody VariantOption variantOption) {
        return variantOptionService.createVariantOption(variantOption);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VariantOption> updateVariantOption(@PathVariable UUID id,
            @RequestBody VariantOption variantOption) {
        VariantOption updatedVariantOption = variantOptionService.updateVariantOption(id, variantOption);
        if (updatedVariantOption != null) {
            return ResponseEntity.ok(updatedVariantOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariantOption(@PathVariable UUID id) {
        variantOptionService.deleteVariantOption(id);
        return ResponseEntity.noContent().build();
    }
}
