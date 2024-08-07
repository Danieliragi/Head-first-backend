package com.alimentationAkonkwa.HeadFirst.dto;

import com.alimentationAkonkwa.HeadFirst.models.Category;
import com.alimentationAkonkwa.HeadFirst.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int stock;
    private Collection<Category> categories;
    private String image;
    private int discountPercentage;

    public static ProductDTO fromEntity(Product product) {
         ProductDTO productDTO = new ProductDTO();
         productDTO.setId(product.getId());
         productDTO.setName(product.getName());
         productDTO.setImage(product.getImage());
         productDTO.setCategories(product.getCategories());
         productDTO.setDescription(product.getDescription());
         productDTO.setPrice(product.getPrice());
         productDTO.setStock(product.getStock());
         productDTO.setDiscountPercentage(product.getDiscountPercentage());
         return productDTO;
    }

    public Product toEntity() {
        Product product = new Product();
        product.setId(this.id);
        product.setName(this.name);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setStock(this.stock);
        product.setImage(this.image);
        product.setDiscountPercentage(this.discountPercentage);
        return product;
    }
}
