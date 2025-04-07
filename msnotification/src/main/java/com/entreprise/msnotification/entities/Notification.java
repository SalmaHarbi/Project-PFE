package com.entreprise.msnotification.entities;

import com.entreprise.msnotification.entities.Enum.Statut;
import com.entreprise.msnotification.entities.Enum.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
public class Notification {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;
    private String message;

    @Enumerated(EnumType.STRING)
    private Type type;

    private String urlaction;

    @Enumerated(EnumType.STRING)
    private Statut statut;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate datecreation;


}
