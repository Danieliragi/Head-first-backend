package com.alimentationAkonkwa.HeadFirst.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.List;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "produits")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @NotEmpty(message = "le nom du produit est obligatoire")
    private String name;
    @Lob
    private String description;
    @NotNull(message = "le prix !")
    @DecimalMin("0.0")
    private Double price;
    private int stock;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Collection<Category> categories;
    //    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Review> reviews;
    @Column(name = "image_Product")
    private String image;
    @Column(name = "reduction_Pourcentage")
    private int discountPercentage;

    @PreRemove
    private void preRemove() {
        for (Category category : categories) {
            category.getProducts().remove(this); // dissocier le produit des catégories
        }
        //    @ManyToOne
//    private Supplier supplier;
//    @OneToMany(mappedBy = "product")
//    private List<OrderItem> orderItems;
//    @OneToOne
//    private Inventory inventory;
    }

}
