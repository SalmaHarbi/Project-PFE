package com.entreprise.msutilisateur.services.serviceimpl;

import com.entreprise.msutilisateur.dtos.ApiResponse;
import com.entreprise.msutilisateur.dtos.DepDto;
import com.entreprise.msutilisateur.entities.Departement;
import com.entreprise.msutilisateur.mappers.DepartementMapper;
import com.entreprise.msutilisateur.repositories.DepartementRepository;
import com.entreprise.msutilisateur.services.serviceinterfaces.DepartementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartementServiceImpl implements DepartementService {

    private final DepartementRepository departementRepository;
    private final DepartementMapper departementMapper;

    public DepartementServiceImpl(DepartementRepository departementRepository,DepartementMapper departementMapper){
        this.departementRepository=departementRepository;
        this.departementMapper=departementMapper;
    }

    @Override
    public DepDto getById(Long id) {
        Departement departement= departementRepository.findById(id).orElse(null);
        return departementMapper.toDto(departement);
    }

    @Override
    public List<DepDto> getAllDepartement() {
        List<Departement> departementList = departementRepository.findAll();
        List<DepDto> dtoList = new ArrayList<>();
        departementList.forEach(departement -> dtoList.add(departementMapper.toDto(departement)));
        return dtoList;
    }


    @Override
    public ApiResponse addDepartement(DepDto depDto) {
        Departement departement=departementMapper.toEntity(depDto);
        departementRepository.save(departement);
        return ApiResponse.builder()
                .id(departement.getId())
                .message("Department has been saved successfuly")
                .build();
    }

    @Override
    public ApiResponse deleteDepartement(Long id) {
        Departement departement = departementRepository.findById(id).orElse(null);
        return ApiResponse.builder()
                .id(departement.getId())
                .message("Department has been deleted successfuly")
                .build();

    }

    @Override
    public ApiResponse updateDepartement(Long id,DepDto depDto) {
        Departement departement= departementRepository.findById(id).orElse(null);
        departementMapper.partialUpdate(depDto,departement);
        departementRepository.save(departement);
        return ApiResponse.builder()
                .id(departement.getId())
                .message("Department has been updated successfuly")
                .build();
    }
}




