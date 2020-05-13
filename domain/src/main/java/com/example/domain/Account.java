package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "account")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "billing_address_line")
    private String billingAddressLine;
    @Column(name = "billing_street")
    private String billingStreet;
    @Column(name = "billing_city")
    private String billingCity;
    @Column(name = "billing_state")
    private String billingState;
    @Column(name = "billing_postcode")
    private String billingPostcode;
    @Column(name = "billing_country")
    private String billingCountry;
    private String website;
    private String description;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "in_active")
    private boolean inActive;
    private String status;
    @Column(name = "contact_name")
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
    @JoinTable(name = "account_assigned_to", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> assignedTo;

    @ManyToMany
    @JoinTable(name = "account_team", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;
}
