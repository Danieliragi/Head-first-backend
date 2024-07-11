//package com.alimentationAkonkwa.HeadFirst.models;
//
//
//import jakarta.persistence.*;
//import jdk.jfr.Timestamp;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//import java.util.List;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "Commande")
//public class Order {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "Date_de_commande")
//    @Timestamp
//    Date date;
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    @OneToMany(mappedBy ="order")
//    private List<OrderItem> orderItem;
//    @OneToOne
//    private Bill bill;
//}
