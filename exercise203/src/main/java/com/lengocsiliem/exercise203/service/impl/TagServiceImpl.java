package com.lengocsiliem.exercise203.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lengocsiliem.exercise203.entity.Tag;
import com.lengocsiliem.exercise203.repository.TagRepository;
import com.lengocsiliem.exercise203.service.TagService;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tag> getTagById(UUID id) {
        return tagRepository.findById(id);
    }

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(UUID id, Tag tagDetails) {
        Tag tag = tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
        tag.setTagName(tagDetails.getTagName());
        tag.setIcon(tagDetails.getIcon());
        tag.setUpdatedAt(OffsetDateTime.now());
        tag.setUpdatedBy(tagDetails.getUpdatedBy());
        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(UUID id) {
        tagRepository.deleteById(id);
    }
}
