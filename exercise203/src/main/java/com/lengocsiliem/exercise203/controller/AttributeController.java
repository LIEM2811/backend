package com.lengocsiliem.exercise203.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.lengocsiliem.exercise203.entity.Attribute;
import com.lengocsiliem.exercise203.service.AttributeService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/attributes")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;

    @GetMapping
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttributes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getAttributeById(@PathVariable UUID id) {
        Attribute attribute = attributeService.getAttributeById(id);
        if (attribute != null) {
            return ResponseEntity.ok(attribute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Attribute createAttribute(@RequestBody Attribute attribute) {
        return attributeService.createAttribute(attribute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Attribute> updateAttribute(@PathVariable UUID id, @RequestBody Attribute attribute) {
        Attribute updatedAttribute = attributeService.updateAttribute(id, attribute);
        if (updatedAttribute != null) {
            return ResponseEntity.ok(updatedAttribute);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAttribute(@PathVariable UUID id) {
        attributeService.deleteAttribute(id);
        return ResponseEntity.noContent().build();
    }
}
