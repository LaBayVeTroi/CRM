package com.example.domain.dto;

import com.example.domain.Document;
import com.example.domain.Team;
import com.example.domain.User;

import java.io.File;
import java.sql.Date;
import java.util.List;

public class DocumentInput implements Input<Document> {

    private String title;
    private File documentFile;
    private Date createdOn;
    private String status;

    private User created_by;

    private List<User> sharedTo;

    private List<Team> teams;

    @Override
    public Document mapper() {
        return Document.builder()
                .title(this.title)
                .documentFile(this.documentFile)
                .createdOn(this.createdOn)
                .status(this.status)
                .created_by(this.created_by)
                .sharedTo(this.sharedTo)
                .teams(this.teams)
                .build();
    }
}
