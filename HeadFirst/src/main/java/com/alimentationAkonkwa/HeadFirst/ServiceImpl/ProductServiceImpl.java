package com.alimentationAkonkwa.HeadFirst.ServiceImpl;

import com.alimentationAkonkwa.HeadFirst.dto.CategoryDTO;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.CategoryAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.models.Category;
import com.alimentationAkonkwa.HeadFirst.models.Product;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductNotFoundException;
import com.alimentationAkonkwa.HeadFirst.repository.CategoryRepository;
import com.alimentationAkonkwa.HeadFirst.repository.ProductRepository;
import com.alimentationAkonkwa.HeadFirst.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) throws ProductAlreadyExistException {
        if (productRepository.existsByName(product.getName())) {
            throw new ProductAlreadyExistException("Product already exists");
        }
        return productRepository.save(product);
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) throws CategoryAlreadyExistException {
        if (categoryRepository.existsByName(categoryDTO.getName())) {
            throw new CategoryAlreadyExistException("Category already exists");
        }
        Category category = categoryDTO.toEntity();
        Category savedCategory = categoryRepository.save(category);
        return CategoryDTO.fromEntity(savedCategory);
    }

    @Override
    public void addProductToCategory(String productName, String categoryName) throws ProductNotFoundException {
        Optional<Category> categoryOpt = categoryRepository.findByName(categoryName);
        Optional<Product> productOpt = productRepository.findByName(productName);

        if (categoryOpt.isPresent() && productOpt.isPresent()) {
            Category category = categoryOpt.get();
            Product product = productOpt.get();
            category.getProducts().add(product);
            categoryRepository.save(category);  // Ensure changes are saved
        } else {
            throw new ProductNotFoundException("Product or Category not found");
        }
    }

    @Override
    public boolean updateProductById(Long id, Product product) throws ProductNotFoundException {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found");
        }
        product.setId(id);
        productRepository.save(product);
        return true;
    }

    @Override
    public boolean deleteProductById(Long id) throws ProductNotFoundException {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found");
        }
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Product> getProductsByCategoryName(String categoryName) {
        return productRepository.findByCategoryName(categoryName);
    }

    @Override
    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
        return productRepository.findByPriceBetween(minPrice, maxPrice);
    }
}
