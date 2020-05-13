package com.example.domain.dto;

import com.example.domain.User;

import javax.persistence.Column;
import java.io.File;
import java.sql.Date;

public class UserInput implements Input<User> {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private boolean isActive;
    private boolean isAdmin;
    private boolean staff;
    private Date dateJoined;
    private String role;
    private File profilePic;
    private boolean hasSalesAccess;
    private boolean hasMarketingAccess;

    @Override
    public User mapper() {
        return User.builder()
                .username(this.username)
                .firstName(this.firstName)
                .lastName(this.lastName)
                .dateJoined(this.dateJoined)
                .email(this.email)
                .hasMarketingAccess(this.hasMarketingAccess)
                .hasSalesAccess(this.hasSalesAccess)
                .isActive(this.isActive)
                .isAdmin(this.isAdmin)
                .profilePic(this.profilePic)
                .role(this.role)
                .staff(this.staff)
                .build();
    }
}
