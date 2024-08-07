package com.alimentationAkonkwa.HeadFirst.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="categorie")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;
    @Column(name = "Nom_Categorie",nullable = false,unique = true)
    @NotEmpty(message = "la categorie svp!")
    private String name;
    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private Collection<Product> products;

    @PreRemove
    private void preRemove() {
        for (Product product : products) {
            product.getCategories().remove(this); // dissocier la catégorie des produits
        }
    }
//    @OneToOne
//    private Inventory inventory;
}
