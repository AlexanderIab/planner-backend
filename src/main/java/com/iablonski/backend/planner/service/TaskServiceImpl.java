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

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskServiceImpl(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Task> getTasksByUserEmail(String email) {
        return taskRepo.findByUserEmailOrderByTitleAsc(email);
    }

    @Override
    public Task addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setTitle(taskDTO.getTitle());
        task.setCompleted(taskDTO.getCompleted());
        task.setPriority(taskDTO.getPriority());
        task.setTaskDate(taskDTO.getTaskDate());
        task.setUser(taskDTO.getUser());
        task.setCategory(taskDTO.getCategory());
        return taskRepo.save(task);
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
    public Page<Task> findByParams(String title, Boolean completed,
                                   String email, Long priorityId,
                                   Long categoryId, Date dateFrom,
                                   Date dateTo, PageRequest pageRequest) {
        return taskRepo.findTaskByParams(title,completed,email,priorityId,categoryId,dateFrom,dateTo,pageRequest);
    }
}
