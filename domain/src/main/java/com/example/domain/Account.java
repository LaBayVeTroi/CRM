package com.example.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

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
}
