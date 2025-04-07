package com.entreprise.msdepense.services.serviceInterface;

import com.entreprise.msdepense.dtos.ApiResponse;
import com.entreprise.msdepense.dtos.DepenseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepenseInterface {
    DepenseDto getById(Long id);
    List<DepenseDto> getAllDepense();
    ApiResponse addDepense(DepenseDto depenseDto);
    ApiResponse deleteDepense(Long id);
    ApiResponse updateDepense(Long id,DepenseDto depenseDto);

}
