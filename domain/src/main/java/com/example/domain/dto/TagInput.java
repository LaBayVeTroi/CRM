package com.example.domain.dto;

import com.example.domain.Tag;

public class TagInput implements Input<Tag> {

    private String name;
    private String slug;

    @Override
    public Tag mapper() {
        return Tag.builder()
                .name(this.name)
                .slug(this.slug)
                .build();
    }
}
