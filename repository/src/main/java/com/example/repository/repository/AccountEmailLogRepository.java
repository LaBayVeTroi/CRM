package com.example.repository.repository;

import com.example.domain.AccountEmailLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountEmailLogRepository extends JpaRepository<AccountEmailLog,Integer> {
}
