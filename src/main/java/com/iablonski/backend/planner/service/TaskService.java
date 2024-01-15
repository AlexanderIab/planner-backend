package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.TaskDTO;
import com.iablonski.backend.planner.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

public interface TaskService {

    TaskDTO getTaskById(Long id);

    List<TaskDTO> getTasksByUserEmail(String email);

    void createTask(TaskDTO taskDTO);

    void updateTask(TaskDTO taskDTO);

    void deleteTaskById(Long id);

    Page<Task> findByParams(String title,
                            Boolean completed,
                            String email,
                            Long priorityId,
                            Long categoryId,
                            Date dateFrom,
                            Date dateTo,
                            PageRequest pageRequest);
}