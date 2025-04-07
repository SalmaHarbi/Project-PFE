package com.entreprise.msdepense.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
public class Justificatif {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomfichierordinal;
    private String cheminstockage;
    private String typemime;
    private Boolean statut;

    private LocalDateTime dateupload= LocalDateTime.now();

    @ManyToOne
    private Depense depense;
}
