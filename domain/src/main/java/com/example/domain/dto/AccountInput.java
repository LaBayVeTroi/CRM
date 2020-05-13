package com.example.domain.dto;

import com.example.domain.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class AccountInput implements Input<Account> {

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

    private User createdBy;

    private Tag tag;

    private Lead lead;

    private List<Contact> contacts;

    private List<User> assignedTo;

    private List<Team> teams;

    @Override
    public Account mapper() {
        return Account.builder().name(this.name)
                .email(this.email)
                .phone(this.phone)
                .industry(this.industry)
                .billingAddressLine(this.billingAddressLine)
                .billingCity(this.billingCity)
                .billingPostcode(this.billingPostcode)
                .billingCountry(this.billingCountry)
                .website(this.website)
                .description(this.description)
                .createdOn(this.createdOn)
                .inActive(this.inActive)
                .status(this.status)
                .contactName(this.contactName)
                .createdBy(this.createdBy)
                .tag(this.tag)
                .lead(this.lead)
                .contacts(this.contacts)
                .assignedTo(this.assignedTo)
                .teams(this.teams)
                .build();
    }
}
