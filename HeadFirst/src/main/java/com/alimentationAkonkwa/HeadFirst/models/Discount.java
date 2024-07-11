//package com.alimentationAkonkwa.HeadFirst.models;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "reduction")
//public class Discount {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String code;
//    private Double percentage;
//    private Date validFrom;
//    private Date validUntil;
//    @OneToOne
//    private Product product;
//    @Column(name = "prix")
//    private int priceAfterDiscount;
//}
