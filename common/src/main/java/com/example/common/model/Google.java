package com.example.common.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "google")
public class Google {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator="native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(name = "id")
    private Integer id;
    private String googleUrl;
    private String verifiedMail;
    private String familyName;
    private String name;
    private String gender;
    private String dob;
    private String givenName;
    private String email;
}
