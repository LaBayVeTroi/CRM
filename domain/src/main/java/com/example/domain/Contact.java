package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.naming.Name;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "contact")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    private String description;
    @Column(name = "created_on")
    private Date createdOn;
    @Column(name = "is_active")
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
