package com.entreprise.msutilisateur.services.serviceinterfaces;

import com.entreprise.msutilisateur.dtos.ApiResponse;
import com.entreprise.msutilisateur.dtos.DepDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartementService {

    DepDto getById(Long id);
    List<DepDto> getAllDepartement();
    ApiResponse addDepartement(DepDto depDto);
    ApiResponse deleteDepartement(Long id);
    ApiResponse updateDepartement(Long id,DepDto depDto);



}
