package com.alimentationAkonkwa.HeadFirst.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "utilisateur")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nom",nullable = false,unique = true)
    @NotEmpty(message = "Le nom ne peut pas être vide")
    private String name;
    @Column(nullable = false,unique = true)
    @Email(message = "L'email doit être valide")
    private String email;
    @Column(name = "numero_telephone")
    @Pattern(regexp = "^\\d{10}$", message = "Le numéro de téléphone doit contenir 10 chiffres")
    private String phoneNumber;
    @NotNull(message = "Le mot de passe est obligatoire")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[^\\w\\s])(?=.*[^\\w\\s]).{8,}$",
            message = "Le mot de passe doit contenir au moins un chiffre, une lettre minuscule, une lettre majuscule, et deux caractères spéciaux.")
    @Column(name = "Mot_de_passe",nullable = false)
    private String password;
//    @OneToMany(mappedBy = "user")
//    private List<Review> reviews;
//    @OneToMany(mappedBy = "user")
//    private List<Order> orders;
//    @OneToMany(mappedBy = "user")
//    private Set<WishList> wishLists;
//    @OneToOne
//    @JoinColumn(name = "Role user")
    private String role;
}
