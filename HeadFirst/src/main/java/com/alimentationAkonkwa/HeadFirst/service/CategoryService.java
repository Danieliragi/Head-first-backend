package com.alimentationAkonkwa.HeadFirst.service;


import com.alimentationAkonkwa.HeadFirst.models.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory(Category category);
    Boolean updateCategory(Long categoryId, Category category);
    Boolean deleteCategoryById(Long id);
    List<Category> getAllCategories();
    Category getCategoryById(Long id);
}
