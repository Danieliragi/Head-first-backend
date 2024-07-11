//package com.alimentationAkonkwa.HeadFirst.models;
//
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotEmpty;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "Adresse")
//public class Address {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @NotEmpty(message = "La ville svp!?")
//    @Column(name = "ville",nullable = false)
//    private String city;
//    @Column(name = "commune",nullable = false)
//    private String commune;
//    @NotEmpty(message = "le quartier svp!")
//    @Column(name = "Quartier",nullable = false)
//    private String quarter;
//    @Column(name = "Numero_Parcelle",nullable = false)
//    private String number;
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//}
