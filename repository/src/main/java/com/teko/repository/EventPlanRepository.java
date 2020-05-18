package com.teko.repository;

import com.teko.domain.EventPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPlanRepository extends JpaRepository<EventPlan,Integer> {
}
