//package com.alimentationAkonkwa.HeadFirst.models;
//
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "mode_de_payment_utilisateur")
//public class UserPaymentMethod {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "Id_client")
//    private Long userId;
//    @Column(name = "date_expiration")
//    private Date expiryDate;
//    @Column(name = "Id_type_payment")
//    private String paymentMethod;
//    @OneToOne
//    private Payment payment;
//}
