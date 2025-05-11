package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.AttributeValue;
import com.lengocsiliem.exercise203.repository.AttributeValueRepository;
import com.lengocsiliem.exercise203.service.AttributeValueService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttributeValueServiceImpl implements AttributeValueService {

    @Autowired
    private AttributeValueRepository attributeValueRepository;

    @Override
    public List<AttributeValue> getAllAttributeValues() {
        return attributeValueRepository.findAll();
    }

    @Override
    public AttributeValue getAttributeValueById(UUID id) {
        Optional<AttributeValue> attributeValue = attributeValueRepository.findById(id);
        return attributeValue.orElse(null);
    }

    @Override
    public AttributeValue createAttributeValue(AttributeValue attributeValue) {
        return attributeValueRepository.save(attributeValue);
    }

    @Override
    public AttributeValue updateAttributeValue(UUID id, AttributeValue attributeValue) {
        if (attributeValueRepository.existsById(id)) {
            attributeValue.setId(id);
            return attributeValueRepository.save(attributeValue);
        }
        return null;
    }

    @Override
    public void deleteAttributeValue(UUID id) {
        attributeValueRepository.deleteById(id);
    }
}
