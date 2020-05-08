package com.example.account.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "account_email")
@Data
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
    @Column(length = 512)
    private String messageSubject;
    @Column(length = 512)
    private String messageBody;
    private String timezone;
    private Date scheduledDateTime;
    private Date scheduledLater;
    private Date createOn;
    private String fromEmail;
    @Column(length = 512)
    private String renderedMessageBody;
}
