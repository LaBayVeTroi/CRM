package com.example.email.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "email")
@Data
public class Email {
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
    private String fromEmail;
    private String toEmail;
    private String subject;
    private String message;
    private String file;
    private Date sendTime;
    private String status;
    private boolean important;

}
