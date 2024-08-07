package com.alimentationAkonkwa.HeadFirst.controller;

import com.alimentationAkonkwa.HeadFirst.dto.CategoryDTO;
import com.alimentationAkonkwa.HeadFirst.dto.UserDto;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.CategoryAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.CategoryNotFoundException;
import com.alimentationAkonkwa.HeadFirst.models.Product;
import com.alimentationAkonkwa.HeadFirst.service.CategoryService;
import com.alimentationAkonkwa.HeadFirst.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {
    private final CategoryService categoryService;


    @Autowired
    public CategoryController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategories() {
        List<CategoryDTO> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(new ApiResponse<>(categories));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        try {
            CategoryDTO category = categoryService.getCategoryById(id);
            return ResponseEntity.ok(category);
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/nom/{nom}")
    public ResponseEntity<CategoryDTO> getCategoryByName(@PathVariable String nom) {
        try {
            CategoryDTO category = categoryService.getCategoryByName(nom);
            return ResponseEntity.ok(category);
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        try {
            CategoryDTO createdCategory = categoryService.createCategory(categoryDTO);
            return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
        } catch (CategoryAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO categoryDTO) {
        try {
            categoryService.updateCategory(id, categoryDTO);
            return ResponseEntity.ok("Catégorie mise à jour avec succès");
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Catégorie non trouvée");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryById(@PathVariable Long id) {
        try {
            categoryService.deleteCategoryById(id);
            return ResponseEntity.ok("Catégorie supprimée avec succès");
        } catch (CategoryNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Catégorie non trouvée");
        }
    }



    // Exception handling for specific exceptions
    @ExceptionHandler({CategoryNotFoundException.class, CategoryAlreadyExistException.class})
    public ResponseEntity<String> handleCategoryException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}




