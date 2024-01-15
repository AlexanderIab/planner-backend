package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.TaskDTO;
import com.iablonski.backend.planner.entity.Task;
import com.iablonski.backend.planner.repository.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public TaskDTO getTaskById(Long id) {
        Task task = taskRepo.findById(id).orElseThrow();
        return this.toDTO(task);
    }

    @Override
    public void createTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setCompleted(taskDTO.getCompleted());
        task.setPriority(taskDTO.getPriority());
        task.setTaskDate(taskDTO.getTaskDate());
        task.setUser(taskDTO.getUser());
        task.setCategory(taskDTO.getCategory());
        taskRepo.save(task);
    }

    @Override
    public void updateTask(TaskDTO taskDTO) {
        Task task = taskRepo.findById(taskDTO.getId()).orElseThrow();
        task.setTitle(taskDTO.getTitle());
        task.setCompleted(taskDTO.getCompleted());
        task.setPriority(taskDTO.getPriority());
        task.setTaskDate(taskDTO.getTaskDate());
        task.setUser(taskDTO.getUser());
        task.setCategory(taskDTO.getCategory());
        taskRepo.save(task);
    }

    @Override
    public void deleteTaskById(Long id) {
        Optional<Task> task = taskRepo.findById(id);
        task.ifPresent(taskRepo::delete);
    }

    @Override
    public List<TaskDTO> getTasksByUserEmail(String email) {
        return taskRepo.findByUserEmailOrderByTitleAsc(email).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Page<Task> findByParams(String title, Boolean completed,
                                   String email, Long priorityId,
                                   Long categoryId, Date dateFrom,
                                   Date dateTo, PageRequest pageRequest) {
        return taskRepo.findTaskByParams(title,completed,email,priorityId,categoryId,dateFrom,dateTo,pageRequest);
    }

    private TaskDTO toDTO(Task task){
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .completed(task.getCompleted())
                .taskDate(task.getTaskDate())
                .priority(task.getPriority())
                .category(task.getCategory())
                .user(task.getUser())
                .build();
    }
}