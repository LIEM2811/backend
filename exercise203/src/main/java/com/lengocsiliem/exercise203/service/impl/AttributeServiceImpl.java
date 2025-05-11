package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Attribute;
import com.lengocsiliem.exercise203.repository.AttributeRepository;
import com.lengocsiliem.exercise203.service.AttributeService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AttributeServiceImpl implements AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    @Override
    public Attribute getAttributeById(UUID id) {
        Optional<Attribute> attribute = attributeRepository.findById(id);
        return attribute.orElse(null);
    }

    @Override
    public Attribute createAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public Attribute updateAttribute(UUID id, Attribute attribute) {
        if (attributeRepository.existsById(id)) {
            attribute.setId(id);
            return attributeRepository.save(attribute);
        }
        return null;
    }

    @Override
    public void deleteAttribute(UUID id) {
        attributeRepository.deleteById(id);
    }
}
