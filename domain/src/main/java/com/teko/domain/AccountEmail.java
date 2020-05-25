package com.teko.domain;


import com.teko.proto.AccountEmailTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "account_email")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountEmail {
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
    @Column(name = "message_subject", length = 512)
    private String messageSubject;
    @Column(name = "message_body", length = 512)
    private String messageBody;
    private String timezone;
    @Column(name = "scheduled_date_time")
    private Date scheduledDateTime;
    @Column(name = "scheduled_later")
    private Date scheduledLater;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "from_email")
    private String fromEmail;
    @Column(name = "rendered_message_body", length = 512)
    private String renderedMessageBody;

    public static AccountEmail fromProto(AccountEmailTranfer accountEmailTranfer){
        return AccountEmail.builder()
                .id(accountEmailTranfer.getId())
                .messageSubject(accountEmailTranfer.getMessageSubject())
                .messageBody(accountEmailTranfer.getMessageBody())
                .timezone(accountEmailTranfer.getTimeZone())
                .scheduledDateTime(new Date(accountEmailTranfer.getScheduledDateTime()))
                .scheduledLater(new Date(accountEmailTranfer.getScheduledLater()))
                .createdOn(new Date(accountEmailTranfer.getCreatedOn()))
                .fromEmail(accountEmailTranfer.getFromEmail())
                .renderedMessageBody(accountEmailTranfer.getRenderedMessageBody())
                .build();
    }

    public AccountEmailTranfer toProto(){
        return AccountEmailTranfer.newBuilder()
                .setId(this.id)
                .setMessageSubject(this.messageSubject)
                .setMessageBody(this.messageBody)
                .setTimeZone(this.timezone)
                .setScheduledDateTime(this.scheduledDateTime.getTime())
                .setScheduledLater(this.scheduledLater.getTime())
                .setCreatedOn(this.createdOn.getTime())
                .setFromEmail(this.fromEmail)
                .setRenderedMessageBody(this.renderedMessageBody)
                .build();
    }
}
