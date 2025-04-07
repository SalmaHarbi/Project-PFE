package com.entreprise.msdepense.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class JustificatifDto {

    @NotEmpty(message = "nom de fichier should not be null")
    private String nomfichierordinal;

    @NotEmpty(message = "chemin should not be null")
    private String cheminstockage;

    @NotEmpty(message = "type should not be null")
    private String typemime;

    @NotNull(message = "statut should not be null")
    private Boolean statut;

    @NotNull(message = "dateupload should not be null")
    private LocalDateTime dateupload = LocalDateTime.now();

}
