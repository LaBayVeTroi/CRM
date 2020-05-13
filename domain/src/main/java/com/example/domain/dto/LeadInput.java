package com.example.domain.dto;

import com.example.domain.Lead;

import javax.persistence.Column;
import java.sql.Date;

public class LeadInput implements Input<Lead> {

    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String status;
    private String source;
    private String addressLine;
    private String street;
    private String city;
    private String state;
    private String postcode;
    private String country;
    private String website;
    private String description;
    private String accountName;
    private Integer opportunityAmount;
    private Date createdOn;
    private boolean isActive;
    private String enqueryType;
    private boolean createdFromSite;

    @Override
    public Lead mapper() {
        return Lead.builder()
                .email(this.email)
                .phone(this.phone)
                .accountName(this.accountName)
                .addressLine(this.addressLine)
                .city(this.city)
                .country(this.country)
                .createdFromSite(this.createdFromSite)
                .createdOn(this.createdOn)
                .description(this.description)
                .enqueryType(this.enqueryType)
                .firstName(this.firstName)
                .isActive(this.isActive)
                .lastName(this.lastName)
                .opportunityAmount(this.opportunityAmount)
                .postcode(this.postcode)
                .source(this.source)
                .state(this.state)
                .status(this.status)
                .street(this.street)
                .title(this.title)
                .website(this.website)
                .build();
    }
}
