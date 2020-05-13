package com.example.domain.dto;

import com.example.domain.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentInput implements Input<Comment> {
    private String comment;
    private Date commentedOn;
    private User commentedBy;
    private Account account;
    private Lead lead;
    private Opportunity opportunity;
    private Contact contact;
    private User user;
    private Task task;
    private Invoice invoice;
    private Event event;

    @Override
    public Comment mapper() {
        return Comment.builder().comment(this.comment)
                .commentedOn(this.commentedOn)
                .commentedBy(this.commentedBy)
                .account(this.account)
                .lead(this.lead)
                .opportunity(this.opportunity)
                .contact(this.contact)
                .user(this.user)
                .task(this.task)
                .invoice(this.invoice)
                .event(this.event)
                .build();
    }

}
