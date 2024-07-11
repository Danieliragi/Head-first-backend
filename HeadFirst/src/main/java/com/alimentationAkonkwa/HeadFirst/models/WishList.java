//package com.alimentationAkonkwa.HeadFirst.models;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "Favoris")
//public class WishList {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    @ManyToMany
//    @JoinTable(
//            name = "wishlist_product",
//            joinColumns = @JoinColumn(name = "wishlist_id"),
//            inverseJoinColumns = @JoinColumn(name = "product_id")
//    )
//    private List<Product> products;
//
//}
