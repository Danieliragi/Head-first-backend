package com.alimentationAkonkwa.HeadFirst.service;


import com.alimentationAkonkwa.HeadFirst.dto.CategoryDTO;
import com.alimentationAkonkwa.HeadFirst.dto.ProductDTO;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.CategoryAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductNotFoundException;
import com.alimentationAkonkwa.HeadFirst.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id) throws ProductNotFoundException;
    Product createProduct(Product product) throws ProductAlreadyExistException;
    CategoryDTO createCategory(CategoryDTO categoryDTO) throws CategoryAlreadyExistException;
    void addProductToCategory(String productName, String categoryName) throws ProductNotFoundException;
    boolean updateProductById(Long id, Product product) throws ProductNotFoundException;
    boolean deleteProductById(Long id) throws ProductNotFoundException;
    List<Product> getProductsByName(String name);
    List<Product> getProductsByPriceRange(double minPrice, double maxPrice);
}
