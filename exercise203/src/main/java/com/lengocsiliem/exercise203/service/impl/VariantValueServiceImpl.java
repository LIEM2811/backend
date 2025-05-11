package com.lengocsiliem.exercise203.service.impl;

import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.VariantValue;
import com.lengocsiliem.exercise203.repository.VariantValueRepository;
import com.lengocsiliem.exercise203.service.VariantValueService;

import java.util.List;
import java.util.UUID;

@Service
public class VariantValueServiceImpl implements VariantValueService {

    private final VariantValueRepository variantValueRepository;

    public VariantValueServiceImpl(VariantValueRepository variantValueRepository) {
        this.variantValueRepository = variantValueRepository;
    }

    @Override
    public VariantValue createVariantValue(VariantValue variantValue) {
        return variantValueRepository.save(variantValue);
    }

    @Override
    public VariantValue getVariantValueById(UUID id) {
        return variantValueRepository.findById(id).orElse(null);
    }

    @Override
    public List<VariantValue> getAllVariantValues() {
        return variantValueRepository.findAll();
    }

    @Override
    public VariantValue updateVariantValue(UUID id, VariantValue variantValue) {
        if (variantValueRepository.existsById(id)) {
            variantValue.setId(id);
            return variantValueRepository.save(variantValue);
        }
        return null;
    }

    @Override
    public void deleteVariantValue(UUID id) {
        variantValueRepository.deleteById(id);
    }
}
