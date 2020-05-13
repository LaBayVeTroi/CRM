package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "`lead`")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String phone;
    @Column(name = "`status`")
    private String status;
    @Column(name = "`source`")
    private String source;
    @Column(name = "address_line")
    private String addressLine;
    private String street;
    private String city;
    @Column(name = "`state`")
    private String state;
    private String postcode;
    private String country;
    private String website;
    @Column(length = 512, name = "`description`")
    private String description;
    @Column(name = "account_name")
    private String accountName;
    @Column(name = "opportunity_amount")
    private Integer opportunityAmount;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "enquery_type")
    private String enqueryType;
    @Column(name = "created_from_site")
    private boolean createdFromSite;
}
