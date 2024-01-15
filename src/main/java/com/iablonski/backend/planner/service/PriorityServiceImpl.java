package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.PriorityDTO;
import com.iablonski.backend.planner.entity.Priority;
import com.iablonski.backend.planner.repository.PriorityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PriorityServiceImpl implements PriorityService{

    private final PriorityRepo priorityRepo;

    @Autowired
    public PriorityServiceImpl(PriorityRepo priorityRepo) {
        this.priorityRepo = priorityRepo;
    }


    @Override
    public PriorityDTO getPriorityById(Long id) {
        Priority priority = priorityRepo.findById(id).orElseThrow();
        return this.toDTO(priority);
    }

    @Override
    public void createPriority(PriorityDTO priorityDTO) {
        Priority priority = new Priority();
        priority.setTitle(priorityDTO.getTitle());
        priority.setColor(priorityDTO.getColor());
        priority.setUser(priorityDTO.getUser());
        priorityRepo.save(priority);
    }

    @Override
    public void updatePriority(PriorityDTO priorityDTO) {
        Priority priority = priorityRepo.findById(priorityDTO.getId()).orElseThrow();
        priority.setTitle(priorityDTO.getTitle());
        priority.setColor(priorityDTO.getColor());
        priority.setUser(priorityDTO.getUser());
        priorityRepo.save(priority);
    }

    @Override
    public void deletePriorityById(Long id) {
        Optional<Priority> priority = priorityRepo.findById(id);
        priority.ifPresent(priorityRepo::delete);
    }

    @Override
    public List<PriorityDTO> getPrioritiesByUserEmail(String email) {
        return priorityRepo.findByUserEmailOrderByTitleAsc(email).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PriorityDTO> findByTitle(String title, String email) {
        return priorityRepo.findByTitle(title, email).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private PriorityDTO toDTO(Priority priority){
        return PriorityDTO.builder()
                .id(priority.getId())
                .title(priority.getTitle())
                .color(priority.getColor())
                .user(priority.getUser())
                .build();
    }
}