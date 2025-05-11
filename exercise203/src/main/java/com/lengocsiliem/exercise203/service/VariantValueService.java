package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.VariantValue;

public interface VariantValueService {
    VariantValue createVariantValue(VariantValue variantValue);

    VariantValue getVariantValueById(UUID id);

    List<VariantValue> getAllVariantValues();

    VariantValue updateVariantValue(UUID id, VariantValue variantValue);

    void deleteVariantValue(UUID id);
}
