package com.iablonski.backend.planner.dto;

import com.iablonski.backend.planner.entity.User;
import lombok.Builder;

@Builder
public class StatDTO {
    private Long id;
    private Long completedTotal;
    private Long uncompletedTotal;
    private User user;
}