package com.entreprise.msutilisateur.dtos;

import com.entreprise.msutilisateur.entities.Departement;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDtoRs {

    @NotEmpty(message = "prenom should not be null")
    private String prenom;

    @NotEmpty(message = "nom should not be null")
    private String nom;

    @NotEmpty(message = "email should not be null")
    private String email;

    @NotEmpty(message = "role should not be null")
    private String role;

    private String photo;

    @NotNull(message = "statut should not be null")
    private Boolean statut;

    @NotNull(message = "datecreation should not be null")
    private LocalDate datecreation;


}
