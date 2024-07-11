//package com.alimentationAkonkwa.HeadFirst.models;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "adresse_livraison")
//public class ShippingAddress {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @OneToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//    @OneToOne
//    @JoinColumn(name = "address_livraison")
//    private Address address;
//    private String state;
//}
