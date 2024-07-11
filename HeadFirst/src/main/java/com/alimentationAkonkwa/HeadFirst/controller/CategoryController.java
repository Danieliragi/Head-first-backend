package com.alimentationAkonkwa.HeadFirst.controller;


import com.alimentationAkonkwa.HeadFirst.models.Category;
import com.alimentationAkonkwa.HeadFirst.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RestController
public class CategoryController {
    private  final CategoryService categoryService;
   @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/api/admin/category")
    public ResponseEntity<Category> createCategory(@Valid @RequestBody Category category){
       return  new ResponseEntity<>(categoryService.createCategory(category),HttpStatus.CREATED);
    }
    @DeleteMapping("/api/admin/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
       Boolean isDeleted = categoryService.deleteCategoryById(categoryId);
       if(isDeleted){
           return new   ResponseEntity<>("CategoryDeleted successfully",HttpStatus.OK);
       }
       return new ResponseEntity<>("not deleted",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/api/admin/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
       return new ResponseEntity<>(categoryService.getAllCategories(),HttpStatus.OK);
    }
}
