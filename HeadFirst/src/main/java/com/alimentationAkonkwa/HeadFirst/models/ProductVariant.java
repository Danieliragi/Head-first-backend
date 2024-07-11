//package com.alimentationAkonkwa.HeadFirst.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "variante_produits")
//public class ProductVariant {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @OneToOne
//    @JoinColumn(name = "Product_id")
//    private Product product;
//    private String Color;
//    private String size;
//    private Double price;
//    private int stockQuantity;
//}
