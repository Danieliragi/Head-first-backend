package com.alimentationAkonkwa.HeadFirst.service;


import com.alimentationAkonkwa.HeadFirst.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product createProduct(Product product);
    Product getProductById(Long id);
    Boolean deleteProductById(Long id);
    Boolean updateProductById(Long id,Product product);
}
