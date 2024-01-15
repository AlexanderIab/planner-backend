package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    CategoryDTO getCategoryById(Long id);
    void createCategory(CategoryDTO categoryDTO);
    void updateCategory(CategoryDTO categoryDTO);
    void deleteCategoryById(Long id);
    List<CategoryDTO> getCategoriesByUserEmail(String email);
    List<CategoryDTO> findByTitle(String title, String email);
}
