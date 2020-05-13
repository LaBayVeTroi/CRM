package com.example.domain.dto;

import com.example.domain.Profile;

import java.sql.Date;

public class ProfileInput implements Input<Profile> {

    private String activationKey;
    private Date keyExpires;

    @Override
    public Profile mapper() {
        return Profile.builder()
                .activationKey(this.activationKey)
                .keyExpires(this.keyExpires)
                .build();
    }
}
