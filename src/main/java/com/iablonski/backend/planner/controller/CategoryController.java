package com.iablonski.backend.planner.controller;

import com.iablonski.backend.planner.dto.CategoryDTO;
import com.iablonski.backend.planner.payload.response.MessageResponse;
import com.iablonski.backend.planner.search.CategorySearchValues;
import com.iablonski.backend.planner.service.CategoryService;
import com.iablonski.backend.planner.validation.ResponseErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/category")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;
    private final ResponseErrorMessage errorMessage;

    @Autowired
    public CategoryController(CategoryService categoryService, ResponseErrorMessage errorMessage) {
        this.categoryService = categoryService;
        this.errorMessage = errorMessage;
    }

    @PostMapping("/id")
    public ResponseEntity<Object> getCategoryById(@RequestBody Long id, BindingResult result){
        return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getCategoriesByUserEmail(@RequestBody String email){
        List<CategoryDTO> categories = categoryService.getCategoriesByUserEmail(email);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> createCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(new MessageResponse("Successfully created"), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageResponse> updateCategory(@RequestBody CategoryDTO categoryDTO){
        categoryService.updateCategory(categoryDTO);
        return new ResponseEntity<>(new MessageResponse("Successfully updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteCategory (@PathVariable("id") Long id){
        categoryService.deleteCategoryById(id);
        return new ResponseEntity<>(new MessageResponse("Successfully deleted"), HttpStatus.OK);
    }

    @PostMapping("/search")
    public ResponseEntity<List<CategoryDTO>> searchCategory(@RequestBody CategorySearchValues values){
        List<CategoryDTO> categories = categoryService.findByTitle(values.getTitle(), values.getEmail());
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}