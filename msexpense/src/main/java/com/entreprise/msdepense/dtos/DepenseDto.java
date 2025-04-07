package com.entreprise.msdepense.dtos;

import com.entreprise.msdepense.entities.Enum.Categorie;
import com.entreprise.msdepense.entities.Enum.Indicateurfiscabilte;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepenseDto {

    @NotNull
    private LocalDateTime datedepense;

    @NotNull
    private Categorie categorie;

    @NotEmpty
    private String description;

    @NotNull
    private BigDecimal montant;

    private String device;

    private BigDecimal tauxchange;

    private BigDecimal montantconverti;

    private String nomfournisseur;

    private String commentaire;

    @NotNull
    private Indicateurfiscabilte indicateurfiscabilte;

    private Boolean statut;

}