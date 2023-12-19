package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.entity.Stat;

public interface StatService {
    Stat findStat(String email);
}
