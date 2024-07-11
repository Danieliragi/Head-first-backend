//package com.alimentationAkonkwa.HeadFirst.models;
//
//
//import jakarta.persistence.*;
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
//@Entity(name = "facture")
//public class Bill {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(nullable = false)
//    private Date billDate;
//    @Column(nullable = false)
//    private Double totalAmount;
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL)
//    private List<Order> orders;
//}
