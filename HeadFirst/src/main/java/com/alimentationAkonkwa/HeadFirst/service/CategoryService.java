package com.alimentationAkonkwa.HeadFirst.service;


import com.alimentationAkonkwa.HeadFirst.dto.CategoryDTO;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.CategoryNotFoundException;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    Boolean deleteCategoryByName(String name);
    CategoryDTO getCategoryById(Long id) throws CategoryNotFoundException;
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryByName(String name);
    void updateCategory(Long id, CategoryDTO categoryDTO) throws CategoryNotFoundException;
    void deleteCategoryById(Long id) throws CategoryNotFoundException;

}
