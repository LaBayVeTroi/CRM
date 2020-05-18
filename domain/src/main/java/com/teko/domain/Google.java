package com.teko.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "google")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Google {
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
    @Column(name = "google_url")
    private String googleUrl;
    @Column(name = "verified_mail")
    private String verifiedMail;
    @Column(name = "family_name")
    private String familyName;
    private String name;
    private String gender;
    private String dob;
    private String givenName;
    private String email;

    @OneToOne
    @JoinColumn(name = "user")
    private User user;

}
