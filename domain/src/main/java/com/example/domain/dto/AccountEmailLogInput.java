package com.example.domain.dto;

import com.example.domain.AccountEmailLog;

public class AccountEmailLogInput implements Input<AccountEmailLog> {
    private boolean isSent;


    @Override
    public AccountEmailLog mapper() {
        return AccountEmailLog.builder().isSent(this.isSent).build();
    }
}
