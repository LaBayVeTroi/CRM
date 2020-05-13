package com.example.domain.dto;

import com.example.domain.APISetting;
import com.example.domain.Tag;
import com.example.domain.User;

import java.sql.Date;
import java.util.List;

public class APISettingInput implements Input<APISetting> {

    private String title;
    private String apiKey;
    private String website;
    private Date createdOn;

    private List<User> users;

    private User createdBy;

    private List<Tag> tags;

    @Override
    public APISetting mapper() {
        return APISetting.builder().apiKey(this.apiKey)
                .createdBy(this.createdBy)
                .createdOn(this.createdOn)
                .tags(this.tags)
                .title(this.title)
                .users(this.users)
                .website(this.website)
                .build();
    }
}
