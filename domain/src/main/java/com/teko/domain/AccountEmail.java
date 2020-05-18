package com.teko.domain;


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
}
