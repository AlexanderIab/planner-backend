package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.PriorityDTO;
import com.iablonski.backend.planner.entity.Priority;

import java.util.List;

public interface PriorityService {
    Priority getPriorityById(Long id);
    List<Priority> getPrioritiesByUserEmail(String email);
    Priority addPriority(PriorityDTO priorityDTO);
    void updatePriority(PriorityDTO priorityDTO);
    void deletePriorityById(Long id);
    List<Priority> findByTitle(String title, String email);
}
