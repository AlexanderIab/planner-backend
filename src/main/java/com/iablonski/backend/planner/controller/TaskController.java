package com.iablonski.backend.planner.controller;

import com.iablonski.backend.planner.dto.TaskDTO;
import com.iablonski.backend.planner.entity.Task;
import com.iablonski.backend.planner.payload.response.MessageResponse;
import com.iablonski.backend.planner.search.TaskSearchValues;
import com.iablonski.backend.planner.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    public static final String ID_COLUMN = "id";
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/id")
    public ResponseEntity<TaskDTO> getTaskById(@RequestBody Long id){
        return new ResponseEntity<>(taskService.getTaskById(id), HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<List<TaskDTO>> getTasksByUserEmail(@RequestBody String email){
        List<TaskDTO> tasks = taskService.getTasksByUserEmail(email);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> createTask(@RequestBody TaskDTO taskDTO){
        taskService.createTask(taskDTO);
        return new ResponseEntity<>(new MessageResponse("Successfully created"), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageResponse> updateTask(@RequestBody TaskDTO taskDTO){
        taskService.updateTask(taskDTO);
        return new ResponseEntity<>(new MessageResponse("Successfully updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteTask(@PathVariable("id") Long id){
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(new MessageResponse("Successfully deleted"), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<Page<Task>> searchTask(@RequestBody TaskSearchValues values){
        Sort sort = Sort.by(values.getSortDirection(), values.getSortColumn(), ID_COLUMN);
        PageRequest pageRequest = PageRequest.of(values.getPageNumber(), values.getPageSize(), sort);
        Page<Task> taskList = taskService
                .findByParams(values.getTitle(),
                        values.getCompleted(),
                        values.getEmail(),
                        values.getPriorityId(),
                        values.getCategoryId(),
                        values.getDateFrom(),
                        values.getDateTo(),
                        pageRequest);
        return new ResponseEntity<>(taskList, HttpStatus.OK);
    }
}