package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.PriorityDTO;
import com.iablonski.backend.planner.entity.Priority;
import com.iablonski.backend.planner.repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriorityServiceImpl implements PriorityService{

    private final PriorityRepo priorityRepo;

    @Autowired
    public PriorityServiceImpl(PriorityRepo priorityRepo) {
        this.priorityRepo = priorityRepo;
    }


    @Override
    public Priority getPriorityById(Long id) {
        return priorityRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Priority> getPrioritiesByUserEmail(String email) {
        return priorityRepo.findByUserEmailOrderByTitleAsc(email);
    }

    @Override
    public Priority addPriority(PriorityDTO priorityDTO) {
        Priority priority = new Priority();
        priority.setId(priorityDTO.getId());
        priority.setTitle(priorityDTO.getTitle());
        priority.setColor(priorityDTO.getColor());
        priority.setUser(priorityDTO.getUser());
        return priorityRepo.save(priority);
    }

    @Override
    public void updatePriority(PriorityDTO priorityDTO) {
        Priority priority = priorityRepo.findById(priorityDTO.getId()).orElseThrow();
        priority.setTitle(priorityDTO.getTitle());
        priority.setColor(priorityDTO.getColor());
        priorityRepo.save(priority);
    }

    @Override
    public void deletePriorityById(Long id) {
        Optional<Priority> priority = priorityRepo.findById(id);
        priority.ifPresent(priorityRepo::delete);
    }

    @Override
    public List<Priority> findByTitle(String title, String email) {
        return priorityRepo.findByTitle(title, email);
    }
}