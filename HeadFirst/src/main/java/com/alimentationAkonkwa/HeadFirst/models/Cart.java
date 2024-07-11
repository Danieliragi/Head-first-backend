//package com.alimentationAkonkwa.HeadFirst.models;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//import java.util.Set;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "panier")
//public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "cart_id")
//    private Long id;
//    @OneToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,orphanRemoval = true)
//    private Set<CartItem> cartItems;
//}
