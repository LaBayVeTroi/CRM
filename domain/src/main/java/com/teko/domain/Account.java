package com.teko.domain;

import com.teko.proto.AccountTranfer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
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

    public static Account fromProto(AccountTranfer accountTranfer) {
        List<User> users = new ArrayList<>();
        accountTranfer.getAssignedToList().forEach(userTranfer -> {
            users.add(User.fromProto(userTranfer));
        });
        List<Contact> contacts = new ArrayList<>();
        accountTranfer.getContactsList().forEach(contactTranfer -> {
            contacts.add(Contact.fromProto(contactTranfer));
        });
        List<Team> teams = new ArrayList<>();
        accountTranfer.getTeamsList().forEach(teamTranfer -> {
            teams.add(Team.fromProto(teamTranfer));
        });
        return Account.builder()
                .id(accountTranfer.getId())
                .name(accountTranfer.getName())
                .email(accountTranfer.getEmail())
                .phone(accountTranfer.getPhone())
                .industry(accountTranfer.getIndustry())
                .billingAddressLine(accountTranfer.getBillingAddressLine())
                .billingCity(accountTranfer.getBillingCity())
                .billingCountry(accountTranfer.getBillingCountry())
                .billingPostcode(accountTranfer.getBillingPostcode())
                .billingState(accountTranfer.getBillingState())
                .billingStreet(accountTranfer.getBillingStreet())
                .website(accountTranfer.getWebsite())
                .description(accountTranfer.getDescription())
                .createdOn(new Date(accountTranfer.getCreatedOn()))
                .inActive(accountTranfer.getInActive())
                .status(accountTranfer.getStatus())
                .contactName(accountTranfer.getContactName())
                .createdBy(User.fromProto(accountTranfer.getCreatedBy()))
                .tag(Tag.fromProto(accountTranfer.getTag()))
                .lead(Lead.fromProto(accountTranfer.getLead()))
                .assignedTo(users)
                .contacts(contacts)
                .teams(teams)
                .build();
    }

    public AccountTranfer toProto() {
        AccountTranfer.Builder builder = AccountTranfer.newBuilder();
        for (int i = 0; i < this.assignedTo.size(); i++) {
            builder = builder.setAssignedTo(i, this.assignedTo.get(i).toProto());
        }
        for (int i = 0; i < this.contacts.size(); i++) {
            builder = builder.setContacts(i, this.contacts.get(i).toProto());
        }
        for (int i = 0; i < this.teams.size(); i++) {
            builder = builder.setTeams(i, this.teams.get(i).toProto());
        }

        builder = builder.setId(this.id)
                .setName(this.name)
                .setEmail(this.email)
                .setPhone(this.phone)
                .setIndustry(this.industry)
                .setBillingAddressLine(this.billingAddressLine)
                .setBillingCity(this.billingCity)
                .setBillingCountry(this.billingCountry)
                .setBillingPostcode(this.billingPostcode)
                .setBillingState(this.billingState)
                .setBillingStreet(this.billingStreet)
                .setWebsite(this.website)
                .setDescription(this.description)
                .setCreatedOn(this.createdOn.getTime())
                .setInActive(this.inActive)
                .setStatus(this.status)
                .setContactName(this.contactName)
                .setCreatedBy(this.createdBy.toProto())
                .setTag(this.tag.toProto())
                .setLead(this.lead.toProto());
        return builder.build();
    }

}
