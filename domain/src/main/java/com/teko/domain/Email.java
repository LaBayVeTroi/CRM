package com.teko.domain;

import com.google.protobuf.GeneratedMessageV3;
import com.teko.proto.EmailTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "email")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email{
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "from_email")
    private String fromEmail;
    @Column(name = "to_email")
    private String toEmail;
    private String subject;
    private String message;
    private String file;
    @Column(name = "send_time")
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
