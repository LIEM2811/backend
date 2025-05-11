package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Variant;

public interface VariantService {
    Variant createVariant(Variant variant);

    Variant getVariantById(UUID id);

    List<Variant> getAllVariants();

    Variant updateVariant(UUID id, Variant variant);

    void deleteVariant(UUID id);
}
