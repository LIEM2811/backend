package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.AttributeValue;
import com.lengocsiliem.exercise203.service.AttributeValueService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attribute-values")
public class AttributeValueController {

    @Autowired
    private AttributeValueService attributeValueService;

    @GetMapping
    public List<AttributeValue> getAllAttributeValues() {
        return attributeValueService.getAllAttributeValues();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttributeValue> getAttributeValueById(@PathVariable UUID id) {
        AttributeValue attributeValue = attributeValueService.getAttributeValueById(id);
        if (attributeValue != null) {
            return ResponseEntity.ok(attributeValue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public AttributeValue createAttributeValue(@RequestBody AttributeValue attributeValue) {
        return attributeValueService.createAttributeValue(attributeValue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttributeValue> updateAttributeValue(@PathVariable UUID id,
            @RequestBody AttributeValue attributeValue) {
        AttributeValue updatedAttributeValue = attributeValueService.updateAttributeValue(id, attributeValue);
        if (updatedAttributeValue != null) {
            return ResponseEntity.ok(updatedAttributeValue);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttributeValue(@PathVariable UUID id) {
        attributeValueService.deleteAttributeValue(id);
        return ResponseEntity.noContent().build();
    }
}
