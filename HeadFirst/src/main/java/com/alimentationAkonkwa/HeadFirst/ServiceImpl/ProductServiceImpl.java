package com.alimentationAkonkwa.HeadFirst.ServiceImpl;

import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductNotFoundException;
import com.alimentationAkonkwa.HeadFirst.models.Product;
import com.alimentationAkonkwa.HeadFirst.repository.ProductRepository;
import com.alimentationAkonkwa.HeadFirst.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new ProductAlreadyExistException("Product already exists. Please check the product ID and try again.");
        }
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found. Please check the product ID: " + id + " and try again."));
    }

    @Override
    public Boolean deleteProductById(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found. Please check the product ID: " + id + " and try again.");
        }
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public Boolean updateProductById(Long id, Product product) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found. Please check the product ID: " + id + " and try again.");
        }
        Product productToUpdate = productRepository.findById(id).get();
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setImage(product.getImage());
        productRepository.save(productToUpdate);
        return true;
    }
}
