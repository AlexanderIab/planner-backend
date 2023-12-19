package com.iablonski.backend.planner.dto;

import com.iablonski.backend.planner.entity.Category;
import com.iablonski.backend.planner.entity.Priority;
import com.iablonski.backend.planner.entity.User;
import lombok.Getter;

import java.util.Date;

@Getter
public class TaskDTO {
    private Long id;
    private String title;
    private Boolean completed;
    private Date taskDate;
    private Priority priority;
    private Category category;
    private User user;
}
