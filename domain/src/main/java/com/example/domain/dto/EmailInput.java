package com.example.domain.dto;

import com.example.domain.Email;

import javax.persistence.Column;
import java.sql.Date;

public class EmailInput implements Input<Email> {
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String message;
    private String file;
    private Date sendTime;
    private String status;
    private boolean important;

    @Override
    public Email mapper() {
        return Email.builder()
                .fromEmail(this.fromEmail)
                .toEmail(this.toEmail)
                .subject(this.subject)
                .message(this.message)
                .file(this.file)
                .sendTime(this.sendTime)
                .status(this.status)
                .important(this.important)
                .build();
    }
}
