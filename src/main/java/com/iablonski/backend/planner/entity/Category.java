package com.iablonski.backend.planner.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "category", schema = "todolist", catalog = "planner")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(name = "completed_count", updatable = false)
    private Long completedCount;

    @Column(name = "uncompleted_count", updatable = false)
    private Long uncompletedCount;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}