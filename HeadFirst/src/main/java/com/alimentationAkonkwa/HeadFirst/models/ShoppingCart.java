//package com.alimentationAkonkwa.HeadFirst.models;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity
//@Table(name = "panier_achat")
//public class ShoppingCart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @JoinColumn(name = "user_id", nullable = false)
//    @OneToOne
//    private User user;
//    @ManyToOne
//    @JoinColumn(name = "produit_id")
//    private Product product;
//    @ManyToOne
//    @JoinColumn(name = "panier")
//    private Cart cart;
//
//}
