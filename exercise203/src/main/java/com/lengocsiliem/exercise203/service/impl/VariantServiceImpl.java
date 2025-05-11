package com.lengocsiliem.exercise203.service.impl;

import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Variant;
import com.lengocsiliem.exercise203.repository.VariantRepository;
import com.lengocsiliem.exercise203.service.VariantService;

import java.util.List;
import java.util.UUID;

@Service
public class VariantServiceImpl implements VariantService {

    private final VariantRepository variantRepository;

    // Remove the @Autowired annotation
    public VariantServiceImpl(VariantRepository variantRepository) {
        this.variantRepository = variantRepository;
    }

    @Override
    public Variant createVariant(Variant variant) {
        return variantRepository.save(variant);
    }

    @Override
    public Variant getVariantById(UUID id) {
        return variantRepository.findById(id).orElse(null);
    }

    @Override
    public List<Variant> getAllVariants() {
        return variantRepository.findAll();
    }

    @Override
    public Variant updateVariant(UUID id, Variant variant) {
        if (variantRepository.existsById(id)) {
            variant.setId(id);
            return variantRepository.save(variant);
        }
        return null;
    }

    @Override
    public void deleteVariant(UUID id) {
        variantRepository.deleteById(id);
    }
}
