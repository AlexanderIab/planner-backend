package com.iablonski.backend.planner.controller;

import com.iablonski.backend.planner.dto.CategoryDTO;
import com.iablonski.backend.planner.entity.Category;
import com.iablonski.backend.planner.search.CategorySearchValues;
import com.iablonski.backend.planner.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/id")
    public ResponseEntity<Category> getCategoryById(@RequestBody Long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/all")
    public List<Category> getCategoriesByUserEmail(@RequestBody String email){
        return categoryService.getCategoriesByUserEmail(email);
    }

    @PostMapping("/add")
    public ResponseEntity<Category> addCategory(@RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.addCategory(categoryDTO), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> updateCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategory(categoryDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Category> deleteCategory (@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<Category>> searchCategory(@RequestBody CategorySearchValues values){
        List<Category> categoryList = categoryService.findByTitle(values.getTitle(), values.getEmail());
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}