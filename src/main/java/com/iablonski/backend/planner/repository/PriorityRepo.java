package com.iablonski.backend.planner.repository;

import com.iablonski.backend.planner.entity.Category;
import com.iablonski.backend.planner.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriorityRepo extends JpaRepository<Priority, Long> {
    List<Priority> findByUserEmailOrderByTitleAsc(String email);

    @Query("SELECT priority from Priority priority where :title is null or :title='' " +
            "or lower(priority.title) like lower(concat('%',:title,'%') ) " +
            "and priority.user.email=:email order by priority.title asc")
    List<Priority> findByTitle(@Param("title") String title, @Param("email") String email);
}
