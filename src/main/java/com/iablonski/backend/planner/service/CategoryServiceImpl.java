package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.CategoryDTO;
import com.iablonski.backend.planner.entity.Category;
import com.iablonski.backend.planner.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        Category category = categoryRepo.findById(id).orElseThrow();
        return this.toDTO(category);
    }

    @Override
    public void createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setTitle(categoryDTO.getTitle());
        category.setUser(categoryDTO.getUser());
        categoryRepo.save(category);
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepo.findById(categoryDTO.getId()).orElseThrow();
        category.setTitle(categoryDTO.getTitle());
        category.setUser(categoryDTO.getUser());
        categoryRepo.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        category.ifPresent(categoryRepo::delete);
    }

    @Override
    public List<CategoryDTO> getCategoriesByUserEmail(String email) {
        return categoryRepo.findByUserEmailOrderByTitleAsc(email).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CategoryDTO> findByTitle(String title, String email) {
        return categoryRepo.findByTitle(title, email).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CategoryDTO toDTO(Category category){
        return CategoryDTO.builder()
                .id(category.getId())
                .title(category.getTitle())
                .completedCount(category.getCompletedCount())
                .uncompletedCount(category.getUncompletedCount())
                .user(category.getUser())
                .build();
    }
}