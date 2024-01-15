package com.iablonski.backend.planner.repository;

import com.iablonski.backend.planner.entity.Stat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatRepo extends JpaRepository<Stat, Long> {
    Optional<Stat> findByUserEmail(String email);
}
