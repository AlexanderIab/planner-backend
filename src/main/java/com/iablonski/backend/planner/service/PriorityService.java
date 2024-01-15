package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.PriorityDTO;
import com.iablonski.backend.planner.entity.Priority;

import java.util.List;

public interface PriorityService {
    PriorityDTO getPriorityById(Long id);
    void createPriority(PriorityDTO priorityDTO);
    void updatePriority(PriorityDTO priorityDTO);
    void deletePriorityById(Long id);
    List<PriorityDTO> getPrioritiesByUserEmail(String email);
    List<PriorityDTO> findByTitle(String title, String email);
}
