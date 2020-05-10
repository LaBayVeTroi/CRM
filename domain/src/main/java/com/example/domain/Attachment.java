package com.example.domain;
import lombok.Data;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;

@Data
@Entity
@Table(name = "attachment")
public class Attachment {
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
    private String fileName;
    private Date createdOn;
    private File attachment;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToOne
    @JoinColumn(name = "`lead`")
    private Lead lead;

    @OneToOne
    @JoinColumn(name = "account")
    private Account account;

    @OneToOne
    @JoinColumn(name = "contact")
    private Contact contact;

    @OneToOne
    @JoinColumn(name = "opportunity")
    private Opportunity opportunity;

    @OneToOne
    @JoinColumn(name = "task")
    private Task task;

    @OneToOne
    @JoinColumn(name = "invoice")
    private Invoice invoice;

    @OneToOne
    @JoinColumn(name = "event")
    private Event event;
}
