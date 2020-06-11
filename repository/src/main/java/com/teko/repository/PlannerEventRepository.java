package com.teko.repository;

import com.teko.domain.PlannerEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlannerEventRepository extends JpaRepository<PlannerEvent, Integer> {
}
