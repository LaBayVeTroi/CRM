package com.example.repository.repository;

import com.example.domain.APISetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSettingRepository extends JpaRepository<APISetting,Integer> {
}
