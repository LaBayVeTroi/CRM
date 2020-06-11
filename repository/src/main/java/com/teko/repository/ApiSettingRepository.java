package com.teko.repository;

import com.teko.domain.APISetting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiSettingRepository extends JpaRepository<APISetting,Integer> {
}
