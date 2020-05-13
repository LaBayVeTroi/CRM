package com.example.domain.dto;

import com.example.domain.Google;
import com.example.domain.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class GoogleInput implements Input<Google> {

    private String googleUrl;
    private String verifiedMail;
    private String familyName;
    private String name;
    private String gender;
    private String dob;
    private String givenName;
    private String email;

    private User user;

    @Override
    public Google mapper() {
        return Google.builder()
                .dob(this.dob)
                .email(this.email)
                .familyName(this.familyName)
                .gender(this.gender)
                .givenName(this.givenName)
                .googleUrl(this.googleUrl)
                .name(this.name)
                .user(this.user)
                .verifiedMail(this.verifiedMail)
                .build();
    }
}
