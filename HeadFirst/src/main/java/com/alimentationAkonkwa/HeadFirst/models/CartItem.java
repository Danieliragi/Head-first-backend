//package com.alimentationAkonkwa.HeadFirst.models;
//
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.NotNull;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "Produits_du_panier ")
//public class CartItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cartItemId")
//    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "cart_id", nullable = false)
//    private Cart cart;
//    @JoinColumn(name = "product_id", nullable = false)
//    @OneToOne
//    private Product product;
//    @NotNull(message = "la quantite ne doit pas etre null")
//    private int quantity;
//}
