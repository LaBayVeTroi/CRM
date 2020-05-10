package com.example.domain;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.naming.Name;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "contact")
@Data
public class Contact {
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
    private String firstName;
    private String lastName;
    private String email;
    private String description;
    private Date createdOn;
    private boolean isActive;
    private String phone;

    @OneToOne
    @JoinColumn(name = "address")
    private Address address;

    @ManyToMany
    @JoinTable(name = "contact_assigned_to", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "address_id"))
    private List<Address> addresses;

    @OneToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @ManyToMany
    @JoinTable(name = "contact_team", joinColumns = @JoinColumn(name = "contact_id"), inverseJoinColumns = @JoinColumn(name = "team_id"))
    private List<Team> teams;
}
