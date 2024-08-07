package com.alimentationAkonkwa.HeadFirst.ServiceImpl;

import com.alimentationAkonkwa.HeadFirst.dto.CategoryDTO;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.CategoryAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.CategoryNotFoundException;
import com.alimentationAkonkwa.HeadFirst.models.Category;
import com.alimentationAkonkwa.HeadFirst.repository.CategoryRepository;
import com.alimentationAkonkwa.HeadFirst.repository.ProductRepository;
import com.alimentationAkonkwa.HeadFirst.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new CategoryAlreadyExistException("Category already exists");
        }
        Category category = categoryDTO.toEntity();
        Category savedCategory = categoryRepository.save(category);
        return   CategoryDTO.fromEntity(savedCategory);
    }


    @Override
    public Boolean deleteCategoryByName(String name) {
        Optional<Category> optionalCategory = categoryRepository.findByName(name);
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found");
        }
        categoryRepository.deleteById(optionalCategory.get().getId());
        return true;
    }

    @Override
    public CategoryDTO getCategoryById(Long id) throws CategoryNotFoundException {
        return (CategoryDTO) categoryRepository.findById(id)
                .map(CategoryDTO::fromEntity)
                .orElseThrow(() -> new CategoryNotFoundException("Catégorie non trouvée"));
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(CategoryDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        Category category = categoryRepository.findByName(name)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found"));
        return  CategoryDTO.fromEntity(category);
    }

    @Override
    public void updateCategory(Long id, CategoryDTO categoryDTO) throws CategoryNotFoundException {
        Optional<Category> optionalCategory = categoryRepository.findByName(categoryDTO.getName());
        if (optionalCategory.isEmpty()) {
            throw new CategoryNotFoundException("Category not found");
        }
        Category categoryToUpdate = optionalCategory.get();
        categoryToUpdate.setName(categoryDTO.getName());
        categoryToUpdate.setProducts(categoryDTO.getProducts());
        categoryRepository.save(categoryToUpdate);
    }


    @Override
    public void deleteCategoryById(Long id) throws CategoryNotFoundException {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException("Catégorie non trouvée");
        }
        categoryRepository.deleteById(id);
    }

}
