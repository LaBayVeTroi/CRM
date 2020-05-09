package com.example.account.service;

import com.example.account.model.Account;
import com.example.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Account account) {
        return accountRepository.saveAndFlush(account);
    }

    public void deleteAccount(Integer id) {
        accountRepository.deleteById(id);
    }

    public Account getAccountById(Integer id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.orElse(null);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }
}
