package com.example.account.graphql;

        import com.coxautodev.graphql.tools.GraphQLMutationResolver;
        import com.example.account.model.Account;
        import com.example.account.repository.AccountRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

@Component
public class AccountMutation implements GraphQLMutationResolver {
    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount() {
        Account account = new Account();
        return accountRepository.save(account);
    }
}
