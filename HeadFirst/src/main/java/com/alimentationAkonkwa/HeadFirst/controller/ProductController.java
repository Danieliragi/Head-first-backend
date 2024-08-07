package com.alimentationAkonkwa.HeadFirst.controller;

import com.alimentationAkonkwa.HeadFirst.dto.ProductDTO;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductAlreadyExistException;
import com.alimentationAkonkwa.HeadFirst.exceptionHandler.ProductNotFoundException;
import com.alimentationAkonkwa.HeadFirst.models.Product;
import com.alimentationAkonkwa.HeadFirst.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/produits")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts().stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/produits/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getProductById(id);
            ProductDTO productDTO = ProductDTO.fromEntity(product);
            return ResponseEntity.ok(productDTO);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/produit")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        try {
            Product createdProduct = productService.createProduct(productDTO.toEntity());
            return new ResponseEntity<>(ProductDTO.fromEntity(createdProduct), HttpStatus.CREATED);
        } catch (ProductAlreadyExistException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
    }

    @PutMapping("/produits/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO productDTO) {
        try {
            boolean isUpdated = productService.updateProductById(id, productDTO.toEntity());
            if (isUpdated) {
                return ResponseEntity.ok("Produit mis à jour avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Produit non mis à jour");
            }
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé");
        }
    }

    @DeleteMapping("/produits/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id) {
        try {
            boolean isDeleted = productService.deleteProductById(id);
            if (isDeleted) {
                return ResponseEntity.ok("Produit supprimé avec succès");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Produit non supprimé");
            }
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produit non trouvé");
        }
    }

    @GetMapping("/produits/nom/{nom}")
    public ResponseEntity<List<ProductDTO>> getProductsByName(@PathVariable String nom) {
        List<ProductDTO> products = productService.getProductsByName(nom).stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/produits/categorie/{categorie}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String categorie) {
        List<ProductDTO> products = productService.getProductsByName(categorie).stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    @GetMapping("/produits/prix")
    public ResponseEntity<List<ProductDTO>> getProductsByPriceRange(@RequestParam double minPrix, @RequestParam double maxPrix) {
        List<ProductDTO> products = productService.getProductsByPriceRange(minPrix, maxPrix).stream()
                .map(ProductDTO::fromEntity)
                .collect(Collectors.toList());
        return ResponseEntity.ok(products);
    }

    // Exception handling for specific exceptions
    @ExceptionHandler({ProductNotFoundException.class, ProductAlreadyExistException.class})
    public ResponseEntity<String> handleProductException(RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
