package com.iablonski.backend.planner.repository;

import com.iablonski.backend.planner.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatRepo extends JpaRepository<Stat, Long> {
    Stat findByUserEmail(String email);
}
