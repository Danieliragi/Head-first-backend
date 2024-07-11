//package com.alimentationAkonkwa.HeadFirst.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotEmpty;
//import jakarta.validation.constraints.Pattern;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "Fourniseur")
//public class Supplier {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "Id_fourniseur")
//    private Long id;
//    @NotEmpty(message = "le nom du fourniseur est obligatoire")
//    @Column(name = "nom",nullable = false)
//    private String name;
//    @Column(name = "numero_telephone")
//    @Pattern(regexp = "^\\d{10}$", message = "Le numéro de téléphone doit contenir 10 chiffres")
//    private String phoneNumber;
//    private String Address;
//    @OneToMany(mappedBy = "supplier")
//    private List<Product> products;
//}
