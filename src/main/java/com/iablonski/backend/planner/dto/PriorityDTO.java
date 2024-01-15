package com.iablonski.backend.planner.dto;

import com.iablonski.backend.planner.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class PriorityDTO {
    private Long id;
    private String title;
    private String color;
    private User user;
}
