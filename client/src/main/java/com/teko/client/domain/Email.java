package com.teko.client.domain;

import com.teko.proto.EmailTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Email {
    private Integer id;
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String message;
    private String file;
    private Date sendTime;
    private String status;
    private boolean important;

    public static Email fromProto(EmailTranfer emailTranfer) {
        return Email.builder()
                .id(emailTranfer.getId())
                .fromEmail(emailTranfer.getFromEmail())
                .toEmail(emailTranfer.getToEmail())
                .subject(emailTranfer.getSubject())
                .message(emailTranfer.getMessage())
                .file(emailTranfer.getFile())
                .sendTime(new Date(emailTranfer.getSendTime()))
                .status(emailTranfer.getStatus())
                .important(emailTranfer.getImportant())
                .build();
    }

    public EmailTranfer toProto() {
        return EmailTranfer.newBuilder()
                .setId(this.id)
                .setFromEmail(this.fromEmail)
                .setToEmail(this.toEmail)
                .setSubject(this.subject)
                .setMessage(this.message)
                .setFile(this.file)
                .setSendTime(this.sendTime.getTime())
                .setStatus(this.status)
                .setImportant(this.important)
                .build();
    }
}
