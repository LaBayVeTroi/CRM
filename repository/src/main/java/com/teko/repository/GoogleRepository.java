package com.teko.repository;

import com.teko.domain.Google;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoogleRepository extends JpaRepository<Google,Integer> {
}
