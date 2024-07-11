//package com.alimentationAkonkwa.HeadFirst.models;
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
//@Entity(name = "Paiement")
//public class Payment {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @OneToMany
//    @Column(name = "commande",nullable = false)
//    private List<Order> order;
//    @OneToOne
//    @Column(name = "mode de paiement")
//    private UserPaymentMethod userPaymentMethod;
//    @Column(name = "Etat_de_paiement")
//    private String paymentStatus;
//    @Column(name = "montant")
//    private Double amount;
//    @Column(name = "message")
//    private String messagePaiment;
//    @OneToOne
//    @JoinColumn(name = "id_utilisateur")
//    private User user;
//    @OneToOne
//    @JoinColumn(name = "id_adresse")
//    private Address address;
//}
