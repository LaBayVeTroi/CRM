package com.example.common.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.File;
import java.sql.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
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
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;
    private boolean isAdmin;
    private boolean staff;
    private Date dateJoined;
    @Column(name = "role")
    private String role;
    private File profilePic;
    private boolean hasSalesAccess;
    private boolean hasMarketingAccess;
}
