package com.lengocsiliem.exercise203.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.lengocsiliem.exercise203.entity.Tag;

public interface TagService {
    List<Tag> getAllTags();

    Optional<Tag> getTagById(UUID id);

    Tag createTag(Tag tag);

    Tag updateTag(UUID id, Tag tagDetails);

    void deleteTag(UUID id);
}
