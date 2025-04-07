package com.entreprise.msnotedefrais.services.serviceInterface;


import com.entreprise.msnotedefrais.dtos.ApiResponse;
import com.entreprise.msnotedefrais.dtos.NoteDeFraisDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NoteDeFraisInterface {
    NoteDeFraisDto getById(Long id);
    List<NoteDeFraisDto> getAllNoteDeFrais();
    ApiResponse addNoteDeFrais(NoteDeFraisDto noteDeFraisDto);
    ApiResponse deleteNoteDeFrais(Long id);
    ApiResponse updateNoteDeFrais(Long id,NoteDeFraisDto noteDeFraisDto);
}
