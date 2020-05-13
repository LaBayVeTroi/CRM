package com.example.domain.dto;

import com.example.domain.AccountEmail;

import java.sql.Date;

public class AccountEmailInput implements Input<AccountEmail> {
    private String messageBody;
    private String timezone;
    private Date scheduledDateTime;
    private Date scheduledLater;
    private Date createdOn;
    private String fromEmail;
    private String renderedMessageBody;

    @Override
    public AccountEmail mapper() {
        return AccountEmail.builder().messageBody(this.messageBody)
                .timezone(this.timezone)
                .scheduledDateTime(this.scheduledDateTime)
                .scheduledLater(this.scheduledLater)
                .createdOn(this.createdOn)
                .fromEmail(this.fromEmail)
                .renderedMessageBody(this.renderedMessageBody)
                .build();
    }
}
