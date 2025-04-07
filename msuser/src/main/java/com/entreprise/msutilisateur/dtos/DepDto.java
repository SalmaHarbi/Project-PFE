package com.entreprise.msutilisateur.dtos;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepDto {

    @NotEmpty(message = "nom should not be null")
    private String nom;

    @NotEmpty(message = "centre de cout should not be null")
    private String centredecout;
}
