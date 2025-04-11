package com.entreprise.msnotedefrais.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {

    private Long id;
    private String prenom;
    private String nom;
    private String email;
    private String role;
    private String photo;
    private Boolean statut;
    private LocalDate datecreation;
    private  String departementNom;
}
