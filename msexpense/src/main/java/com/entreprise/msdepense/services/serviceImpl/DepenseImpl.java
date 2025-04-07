package com.entreprise.msdepense.services.serviceImpl;

import com.entreprise.msdepense.dtos.ApiResponse;
import com.entreprise.msdepense.dtos.DepenseDto;
import com.entreprise.msdepense.entities.Depense;
import com.entreprise.msdepense.mappers.DepenseMapper;
import com.entreprise.msdepense.repositories.DepenseRepository;
import com.entreprise.msdepense.services.serviceInterface.DepenseInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepenseImpl implements DepenseInterface {

    private final DepenseRepository depenseRepository;
    private final DepenseMapper depenseMapper;

    public DepenseImpl(DepenseRepository depenseRepository,DepenseMapper depenseMapper){
        this.depenseRepository=depenseRepository;
        this.depenseMapper=depenseMapper;
    }



    @Override
    public DepenseDto getById(Long id) {
        Depense depense= depenseRepository.findById(id).orElse(null);
        return depenseMapper.toDto(depense);
    }

    @Override
    public List<DepenseDto> getAllDepense() {
        List<Depense> depenses=depenseRepository.findAllDepenseByStatut(true);
        List<DepenseDto> dtos=new ArrayList<>();
        depenses.forEach(e->dtos.add(depenseMapper.toDto(e)));
        return dtos;
    }

    @Override
    public ApiResponse addDepense(DepenseDto depenseDto) {
        Depense depense=depenseMapper.toEntity(depenseDto);
        depenseRepository.save(depense);
        return ApiResponse.builder()
                .id(depense.getId())
                .message("Depense has been saved successfuly")
                .build();
    }

    @Override
    public ApiResponse deleteDepense(Long id) {
        Depense depense = depenseRepository.findById(id).orElse(null);
        depense.setStatut(false);
        depenseRepository.save(depense);
        return ApiResponse.builder()
                .id(depense.getId())
                .message("Depense has been deleted successfuly")
                .build();
    }

    @Override
    public ApiResponse updateDepense(Long id, DepenseDto depenseDto) {
        Depense depense= depenseRepository.findById(id).orElse(null);
        depenseMapper.partialUpdate(depenseDto,depense);
        depenseRepository.save(depense);
        return ApiResponse.builder()
                .id(depense.getId())
                .message("Depense has been updated successfuly")
                .build();

    }
}
