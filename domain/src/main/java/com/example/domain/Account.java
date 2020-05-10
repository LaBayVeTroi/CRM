package com.example.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "account")
@Data
public class Account {
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
    private String name;
    private String email;
    private String phone;
    private String industry;
    private String billingAddressLine;
    private String billingStreet;
    private String billingCity;
    private String billingState;
    private String billingPostcode;
    private String billingCountry;
    private String website;
    private String description;
    private Date createdOn;
    private boolean inActive;
    private String status;
    private String contactName;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToOne
    @JoinColumn(name = "tag")
    private Tag tag;

    @OneToOne
    @JoinColumn(name = "`lead`")
    private Lead lead;

    @ManyToMany
    @JoinTable(name = "account_contact", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "contact_id"))
    private List<Contact> contacts;

    @ManyToMany
    @JoinTable(name = "account_assigned_to", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = user_id))
    private List<User> assignedTo;

    @ManyToMany
    @JoinTable(name = "account_team", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;
}
