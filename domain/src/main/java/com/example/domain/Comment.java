package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity(name = "comment")
@Data
public class Comment {
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
    private String comment;
    @Column(name = "commented_on")
    private Date commentedOn;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "commented_by")
    private User commentedBy;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id")
    private Account account;
    @OneToOne
    @JoinColumn(name = "`lead`")
    private Lead lead;
    @OneToOne
    @JoinColumn(name = "opportunity")
    private Opportunity opportunity;
    @ManyToOne
    @JoinColumn(name = "contact")
    private Contact contact;
    @ManyToOne
    @JoinColumn(name = "user")
    private User user;
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
