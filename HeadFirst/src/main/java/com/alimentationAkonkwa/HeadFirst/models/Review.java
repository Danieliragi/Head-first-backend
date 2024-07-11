//package com.alimentationAkonkwa.HeadFirst.models;
//
//import jakarta.persistence.*;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.validation.annotation.Validated;
//import javax.naming.Name;
//import java.util.Date;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Entity(name = "revue")
//public class Review {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Size(min = 5,max = 500,message = "veillez saisir au moins une ligne")
//    @Column(nullable = false)
//    private String content;
//    @Size(min = 1, max = 5)
//    private int rating;
//    @ManyToOne
//    @JoinColumn(name = "product_id", nullable = false)
//    private Product product;
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdAt;
//}
