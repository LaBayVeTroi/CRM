package com.example.domain.dto;

import com.example.domain.Team;
import com.example.domain.User;

import java.sql.Date;
import java.util.List;

public class TeamInput implements Input<Team> {

    private String name;
    private String description;
    private Date createdOn;

    private List<User> users;

    private User createdBy;

    @Override
    public Team mapper() {
        return Team.builder()
                .createdBy(this.createdBy)
                .createdOn(this.createdOn)
                .description(this.description)
                .name(this.name)
                .users(this.users)
                .build();
    }
}
