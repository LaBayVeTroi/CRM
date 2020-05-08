package com.example.lead.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "`lead`")
@Data
public class Lead {
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
    @Column(name = "`title`")
    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @Column(name = "`status`")
    private String status;
    @Column(name = "`source`")
    private String source;
    private String addressLine;
    private String street;
    private String city;
    @Column(name = "`state`")
    private String state;
    private String postcode;
    private String country;
    private String website;
    @Column(length = 512,name = "`description`")
    private String description;
    private String accountName;
    private Integer opportunityAmount;
    private Date createdOn;
    private boolean isActive;
    private String enqueryType;
    private boolean createdFromSite;
}
