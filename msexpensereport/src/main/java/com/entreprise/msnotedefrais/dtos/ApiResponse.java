package com.entreprise.msnotedefrais.dtos;

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
