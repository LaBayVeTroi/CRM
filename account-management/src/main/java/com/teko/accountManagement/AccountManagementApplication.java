package com.teko.accountManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.teko"})
@EnableJpaRepositories(
        basePackages = "com.teko.repository",
        entityManagerFactoryRef = "entityManager"
)
public class AccountManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(AccountManagementApplication.class, args);
    }
}
