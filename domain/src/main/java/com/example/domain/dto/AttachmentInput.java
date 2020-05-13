package com.example.domain.dto;

import com.example.domain.*;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.io.File;
import java.sql.Date;

public class AttachmentInput implements Input<Attachment> {

    private String fileName;
    private Date createdOn;
    private File attachment;

    private User createdBy;

    private Lead lead;

    private Account account;

    private Contact contact;

    private Opportunity opportunity;

    private Task task;

    private Invoice invoice;

    private Event event;

    @Override
    public Attachment mapper() {
        return Attachment.builder()
                .fileName(this.fileName)
                .createdOn(this.createdOn)
                .account(this.account)
                .lead(this.lead)
                .opportunity(this.opportunity)
                .contact(this.contact)
                .attachment(this.attachment)
                .task(this.task)
                .invoice(this.invoice)
                .event(this.event)
                .createdBy(this.createdBy)
                .build();
    }
}
