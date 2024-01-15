package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.StatDTO;

public interface StatService {
    StatDTO findStat(String email);
}
