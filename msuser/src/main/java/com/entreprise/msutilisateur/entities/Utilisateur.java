package com.entreprise.msutilisateur.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Utilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;
    private String email;
    private String motdepasse;
    private String role;
    private String photo;
    private Boolean statut;
    private LocalDateTime datecreation = LocalDateTime.now();

    @ManyToOne
    private Departement departement;

}
