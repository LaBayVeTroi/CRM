package com.example.domain.dto;

import com.example.domain.Address;
import com.example.domain.Contact;
import com.example.domain.Team;
import com.example.domain.User;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class ContactInput implements Input<Contact> {

    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private Date createdOn;
    private boolean isActive;
    private String phone;

    private Address address;

    private List<Address> addresses;

    private User createdBy;

    private List<Team> teams;

    @Override
    public Contact mapper() {
        return Contact.builder()
                .firstName(this.firstName)
                .lastName(this.lastName)
                .address(this.address)
                .addresses(this.addresses)
                .createdBy(this.createdBy)
                .teams(this.teams)
                .build();
    }
}
