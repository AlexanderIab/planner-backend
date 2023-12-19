package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.entity.Stat;
import com.iablonski.backend.planner.repository.StatRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatServiceImpl implements StatService{

    private final StatRepo statRepo;

    @Autowired
    public StatServiceImpl(StatRepo statRepo) {
        this.statRepo = statRepo;
    }

    @Override
    public Stat findStat(String email) {
        return statRepo.findByUserEmail(email);
    }
}
