package com.example.account.graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.account.model.Account;
import com.example.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountQuery implements GraphQLQueryResolver {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }
}
