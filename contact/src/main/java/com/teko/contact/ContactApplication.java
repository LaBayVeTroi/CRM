package com.teko.contact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.teko", "config"})
@EnableJpaRepositories(
        basePackages = "com.teko.repository",
        entityManagerFactoryRef = "entityManager"
)
@EntityScan(basePackages = "com.teko.domain")
public class ContactApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class, args);
    }
}
