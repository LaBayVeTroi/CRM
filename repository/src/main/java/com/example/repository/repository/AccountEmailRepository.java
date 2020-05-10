package com.example.repository.repository;

import com.example.domain.AccountEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEmailRepository extends JpaRepository<AccountEmail,Integer> {
}
