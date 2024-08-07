package com.alimentationAkonkwa.HeadFirst.dto;

import com.alimentationAkonkwa.HeadFirst.models.Category;
import com.alimentationAkonkwa.HeadFirst.models.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Long id;
    private String name;
    @Getter
    private Collection<Product> products;

    public Category toEntity() {
        Category category = new Category();
        category.setId(this.id);
        category.setName(this.name);
        category.setProducts(this.products);
        return category;
    }

    public static CategoryDTO fromEntity(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts());
        return categoryDTO;
    }
}
