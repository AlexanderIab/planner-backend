package com.iablonski.backend.planner.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.type.NumericBooleanConverter;

import java.util.Date;

@Entity
@Table(name = "task", schema = "todolist", catalog = "planner")
@Data
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Convert(converter = NumericBooleanConverter.class)
    private Boolean completed;

    @Column(name = "task_date")
    private Date taskDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
