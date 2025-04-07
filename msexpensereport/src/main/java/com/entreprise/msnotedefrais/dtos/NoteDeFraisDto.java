package com.entreprise.msnotedefrais.dtos;

import com.entreprise.msnotedefrais.entities.Enum.Statut;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class NoteDeFraisDto  {

    @NotEmpty(message = "titre should not be null")
    String titre;

    @NotNull(message = "date should not be null")
    LocalDateTime datesoumission;

    @NotEmpty(message = "motif should not be null")
    String motifnotefrais;

    @NotNull(message = "statut should not be null")
    Statut statut;

    String commentaire;

    @NotNull(message = "date should not be null")
    LocalDate dateapprobationrejet;

    @NotEmpty(message = "raison should not be null")
    String raisondurejet;

    @NotNull(message = "montant should not be null")
    Float montanttotal;


}