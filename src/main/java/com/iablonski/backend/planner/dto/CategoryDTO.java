package com.iablonski.backend.planner.dto;

import com.iablonski.backend.planner.entity.User;
import lombok.Data;

@Data
public class CategoryDTO {
    private Long id;
    private String title;
    private User user;
}