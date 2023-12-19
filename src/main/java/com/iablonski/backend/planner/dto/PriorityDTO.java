package com.iablonski.backend.planner.dto;

import com.iablonski.backend.planner.entity.User;
import lombok.Data;

@Data
public class PriorityDTO {
    private Long id;
    private String title;
    private String color;
    private User user;
}
