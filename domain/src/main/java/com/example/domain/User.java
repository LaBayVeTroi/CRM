package com.example.domain;

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
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "is_admin")
    private boolean isAdmin;
    private boolean staff;
    @Column(name = "date_joined")
    private Date dateJoined;
    @Column(name = "role")
    private String role;
    @Column(name = "proile_pic")
    private File profilePic;
    @Column(name = "has_sales_access")
    private boolean hasSalesAccess;
    @Column(name = "has_marketing_access")
    private boolean hasMarketingAccess;
}
