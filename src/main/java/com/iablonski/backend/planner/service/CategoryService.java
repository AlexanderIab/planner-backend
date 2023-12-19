package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.CategoryDTO;
import com.iablonski.backend.planner.entity.Category;

import java.util.List;

public interface CategoryService {
    Category getCategoryById(Long id);
    List<Category> getCategoriesByUserEmail(String email);
    Category addCategory(CategoryDTO categoryDTO);
    void updateCategory(CategoryDTO categoryDTO);
    void deleteCategoryById(Long id);
    List<Category> findByTitle(String title, String email);
}
