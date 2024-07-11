package com.alimentationAkonkwa.HeadFirst.controller;
import com.alimentationAkonkwa.HeadFirst.models.Product;
import com.alimentationAkonkwa.HeadFirst.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/produits/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
    @PostMapping("/produit")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product){
        return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);
    }
    @PutMapping("/produits/{id}")
    public  ResponseEntity<String> updateProduct(@PathVariable Long id,@Valid @RequestBody Product product){
        Boolean isUpdated = productService.updateProductById(id,product);
        if(isUpdated){
            return new ResponseEntity<>("updated successfully",HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not updated",HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/produits/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable Long id){
        Boolean isDeleted = productService.deleteProductById(id);
        if(isDeleted){
            return new ResponseEntity<>("deleted successfully",HttpStatus.OK);
        }
        return  new ResponseEntity<>("not deleted",HttpStatus.NOT_FOUND);
    }
}
