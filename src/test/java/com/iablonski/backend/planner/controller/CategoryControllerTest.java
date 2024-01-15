package com.iablonski.backend.planner.controller;

import com.iablonski.backend.planner.entity.Category;
import com.iablonski.backend.planner.service.CategoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryControllerTest {

    @Mock
    CategoryService categoryService;

    @InjectMocks
    CategoryController categoryController;
//
//    @Test
//    @DisplayName("POST - /api/category/all - Get all categories by Email - HTTP-status OK")
////    void getCategoriesByUserEmailReturnsValidResponseEntity(){
////        // given
//////        var categories = List.of(new Category(1L, "TestCat1"),new Category(2L, "TestCat2"));
////        doReturn(categories).when(this.categoryService).getCategoriesByUserEmail("test@test.com");
////
////        // when
////        var responseEntity = this.categoryController.getCategoriesByUserEmail("test@test.com");
////
////        // then
////        assertNotNull(responseEntity);
////        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//////        assertTrue(MediaType.APPLICATION_JSON.isCompatibleWith(MediaType.parseMediaType(responseEntity.getHeaders().getContentType().)));
////        assertEquals(categories, responseEntity.getBody());
////    }
}
