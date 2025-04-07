package com.entreprise.msdepense.services.serviceInterface;

import com.entreprise.msdepense.dtos.ApiResponse;
import com.entreprise.msdepense.dtos.DepenseDto;
import com.entreprise.msdepense.dtos.JustificatifDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface JustificatifInterface {
    JustificatifDto getById(Long id);
    List<JustificatifDto> getAllJustificatif();
    ApiResponse UploadJustificatif(JustificatifDto justificatifDto);
    ApiResponse deleteJustificatif(Long id);

}
