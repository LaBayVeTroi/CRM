package com.example.repository.repository;

import com.example.domain.Google;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoogleRepository extends JpaRepository<Google,Integer> {
}
