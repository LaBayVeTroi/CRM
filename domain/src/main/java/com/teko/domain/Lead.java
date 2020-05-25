package com.teko.domain;

import com.teko.proto.LeadTranfer;
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

    public static Lead fromProto(LeadTranfer leadTranfer){
        return Lead.builder()
                .id(leadTranfer.getId())
                .title(leadTranfer.getTitle())
                .firstName(leadTranfer.getFirstName())
                .lastName(leadTranfer.getLastName())
                .email(leadTranfer.getEmail())
                .phone(leadTranfer.getPhone())
                .status(leadTranfer.getStatus())
                .source(leadTranfer.getSource())
                .addressLine(leadTranfer.getAddressLine())
                .street(leadTranfer.getStreet())
                .city(leadTranfer.getCity())
                .state(leadTranfer.getState())
                .postcode(leadTranfer.getPostcode())
                .country(leadTranfer.getCountry())
                .website(leadTranfer.getWebsite())
                .description(leadTranfer.getDescription())
                .accountName(leadTranfer.getAccountName())
                .opportunityAmount(leadTranfer.getOpportunityAmount())
                .createdOn(new Date(leadTranfer.getCreatedOn()))
                .isActive(leadTranfer.getIsActive())
                .enqueryType(leadTranfer.getEnqueryType())
                .createdFromSite(leadTranfer.getCreatedFromSite())
                .build();
    }

    public LeadTranfer toProto() {
        return LeadTranfer.newBuilder()
                .setId(this.id)
                .setTitle(this.title)
                .setFirstName(this.firstName)
                .setLastName(this.lastName)
                .setEmail(this.email)
                .setPhone(this.phone)
                .setStatus(this.status)
                .setSource(this.source)
                .setAddressLine(this.addressLine)
                .setStreet(this.street)
                .setCity(this.city)
                .setState(this.state)
                .setPostcode(this.postcode)
                .setCountry(this.country)
                .setWebsite(this.website)
                .setDescription(this.description)
                .setAccountName(this.accountName)
                .setOpportunityAmount(this.opportunityAmount)
                .setCreatedOn(this.createdOn.getTime())
                .setIsActive(this.isActive)
                .setEnqueryType(this.enqueryType)
                .setCreatedFromSite(this.createdFromSite)
                .build();
    }
}
