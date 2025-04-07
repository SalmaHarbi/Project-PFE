package com.entreprise.msutilisateur.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoRq {

    @NotEmpty(message = "prenom should not be null")
    private String prenom;

    @NotEmpty(message = "nom should not be null")
    private String nom;

    @NotEmpty(message = "email should not be null")
    private String email;

    @NotEmpty(message = "motdepasse should not be null")
    private String motdepasse;

    @NotEmpty(message = "role should not be null")
    private String role;

    private String photo;

    @NotNull(message = "statut should not be null")
    private Boolean statut;

}
