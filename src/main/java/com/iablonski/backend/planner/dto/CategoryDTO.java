package com.iablonski.backend.planner.dto;

import com.iablonski.backend.planner.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class CategoryDTO {
    private Long id;
    private String title;
    private Long completedCount;
    private Long uncompletedCount;
    private User user;
}