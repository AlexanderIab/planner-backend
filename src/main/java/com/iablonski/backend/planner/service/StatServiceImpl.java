package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.StatDTO;
import com.iablonski.backend.planner.entity.Stat;
import com.iablonski.backend.planner.repository.StatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatServiceImpl implements StatService {

    private final StatRepo statRepo;

    @Autowired
    public StatServiceImpl(StatRepo statRepo) {
        this.statRepo = statRepo;
    }

    @Override
    public StatDTO findStat(String email) {
        Stat stat = statRepo.findByUserEmail(email).orElseThrow();
        return StatDTO.builder()
                .id(stat.getId())
                .completedTotal(stat.getCompletedTotal())
                .uncompletedTotal(stat.getUncompletedTotal())
                .user(stat.getUser())
                .build();
    }
}