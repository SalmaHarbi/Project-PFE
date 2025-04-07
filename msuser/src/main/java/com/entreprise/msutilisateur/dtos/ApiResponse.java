package com.entreprise.msutilisateur.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

    private Long id;
    private String message;

}
