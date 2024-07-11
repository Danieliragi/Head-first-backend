package com.alimentationAkonkwa.HeadFirst.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name ="categorie")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categorie_Id")
    private Long id;
    @Column(name = "Nom_Categorie",nullable = false,unique = true)
    @NotEmpty(message = "la categorie svp!")
    private String name;
    @OneToMany
    @Column(name = "product_id")
    private Set<Product> products;
//    @OneToOne
//    private Inventory inventory;
}
