package com.iablonski.backend.planner.service;

import com.iablonski.backend.planner.dto.CategoryDTO;
import com.iablonski.backend.planner.entity.Category;
import com.iablonski.backend.planner.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepo categoryRepo;

    @Autowired
    public CategoryServiceImpl(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepo.findById(id).orElseThrow();
    }

    @Override
    public List<Category> getCategoriesByUserEmail(String email) {
        return categoryRepo.findByUserEmailOrderByTitleAsc(email);
    }

    @Override
    public Category addCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setTitle(categoryDTO.getTitle());
        category.setUser(categoryDTO.getUser());
        return categoryRepo.save(category);
    }

    @Override
    public void updateCategory(CategoryDTO categoryDTO) {
        Category category = categoryRepo.findById(categoryDTO.getId()).orElseThrow();
        category.setTitle(categoryDTO.getTitle());
//        category.setUser(categoryDTO.getUser());
        categoryRepo.save(category);
    }

    @Override
    public void deleteCategoryById(Long id) {
        Optional<Category> category = categoryRepo.findById(id);
        category.ifPresent(categoryRepo::delete);
    }

    @Override
    public List<Category> findByTitle(String title, String email) {
        return categoryRepo.findByTitle(title, email);
    }
}