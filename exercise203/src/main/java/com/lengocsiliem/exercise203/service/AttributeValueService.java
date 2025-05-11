package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.AttributeValue;

public interface AttributeValueService {
    List<AttributeValue> getAllAttributeValues();

    AttributeValue getAttributeValueById(UUID id);

    AttributeValue createAttributeValue(AttributeValue attributeValue);

    AttributeValue updateAttributeValue(UUID id, AttributeValue attributeValue);

    void deleteAttributeValue(UUID id);
}
