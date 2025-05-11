package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.VariantOption;

public interface VariantOptionService {
    List<VariantOption> getAllVariantOptions();

    VariantOption getVariantOptionById(UUID id);

    VariantOption createVariantOption(VariantOption variantOption);

    VariantOption updateVariantOption(UUID id, VariantOption variantOption);

    void deleteVariantOption(UUID id);
}
