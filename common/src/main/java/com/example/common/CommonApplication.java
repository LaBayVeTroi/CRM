package com.example.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableJpaRepositories(
        basePackages = "com.example.repository.repository",
        entityManagerFactoryRef = "entityManager"
)
@EntityScan(basePackages = "com.example.domain")
public class CommonApplication  {
    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }
}
