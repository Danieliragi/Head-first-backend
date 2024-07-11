package com.alimentationAkonkwa.HeadFirst.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produits")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "le nom du produit est obligatoire")
    @Column(name = "nom_produit")
    private String name;
    @Lob
    private String description;
    @NotNull(message = "le prix !")
    @DecimalMin("0.0")
    private Double price;
    private int stock;
    @ManyToMany
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;
//    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Review> reviews;
     @Column(name = "image_Product")
      private String image;
     @Column(name = "reduction_Pourcentage")
     private int discountPercentage;
//    @ManyToOne
//    private Supplier supplier;
//    @OneToMany(mappedBy = "product")
//    private List<OrderItem> orderItems;
//    @OneToOne
//    private Inventory inventory;
}
