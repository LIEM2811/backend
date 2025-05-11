package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.VariantOption;
import com.lengocsiliem.exercise203.repository.VariantOptionRepository;
import com.lengocsiliem.exercise203.service.VariantOptionService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VariantOptionServiceImpl implements VariantOptionService {

    @Autowired
    private VariantOptionRepository variantOptionRepository;

    @Override
    public List<VariantOption> getAllVariantOptions() {
        return variantOptionRepository.findAll();
    }

    @Override
    public VariantOption getVariantOptionById(UUID id) {
        Optional<VariantOption> variantOption = variantOptionRepository.findById(id);
        return variantOption.orElse(null);
    }

    @Override
    public VariantOption createVariantOption(VariantOption variantOption) {
        return variantOptionRepository.save(variantOption);
    }

    @Override
    public VariantOption updateVariantOption(UUID id, VariantOption variantOption) {
        if (variantOptionRepository.existsById(id)) {
            variantOption.setId(id);
            return variantOptionRepository.save(variantOption);
        }
        return null;
    }

    @Override
    public void deleteVariantOption(UUID id) {
        variantOptionRepository.deleteById(id);
    }
}
