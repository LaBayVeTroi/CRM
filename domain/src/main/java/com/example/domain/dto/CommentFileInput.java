package com.example.domain.dto;

import com.example.domain.Comment;
import com.example.domain.CommentFile;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.File;
import java.sql.Date;

public class CommentFileInput implements Input<CommentFile> {

    private Date updatedOn;
    private File commentFile;
    private Comment comment;

    @Override
    public CommentFile mapper() {
        return CommentFile.builder()
                .updatedOn(this.updatedOn)
                .comment(this.comment)
                .commentFile(this.commentFile)
                .build();
    }
}
