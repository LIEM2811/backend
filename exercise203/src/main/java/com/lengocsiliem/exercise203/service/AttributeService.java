package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Attribute;

public interface AttributeService {
    List<Attribute> getAllAttributes();

    Attribute getAttributeById(UUID id);

    Attribute createAttribute(Attribute attribute);

    Attribute updateAttribute(UUID id, Attribute attribute);

    void deleteAttribute(UUID id);
}
