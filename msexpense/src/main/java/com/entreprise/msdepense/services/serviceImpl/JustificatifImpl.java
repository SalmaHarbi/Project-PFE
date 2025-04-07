package com.entreprise.msdepense.services.serviceImpl;

import com.entreprise.msdepense.dtos.ApiResponse;
import com.entreprise.msdepense.dtos.DepenseDto;
import com.entreprise.msdepense.dtos.JustificatifDto;
import com.entreprise.msdepense.entities.Depense;
import com.entreprise.msdepense.entities.Justificatif;
import com.entreprise.msdepense.mappers.DepenseMapper;
import com.entreprise.msdepense.mappers.JustificatifMapper;
import com.entreprise.msdepense.repositories.DepenseRepository;
import com.entreprise.msdepense.repositories.JustificatifRepository;
import com.entreprise.msdepense.services.serviceInterface.JustificatifInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JustificatifImpl implements JustificatifInterface {


    private final JustificatifRepository justificatifRepository;
    private final JustificatifMapper justificatifMapper;

    public JustificatifImpl(JustificatifRepository justificatifRepository,JustificatifMapper justificatifMapper){
        this.justificatifRepository=justificatifRepository;
        this.justificatifMapper=justificatifMapper;
    }


    @Override
    public JustificatifDto getById(Long id) {
        Justificatif justificatif= justificatifRepository.findById(id).orElse(null);
        return justificatifMapper.toDto(justificatif);
    }

    @Override
    public List<JustificatifDto> getAllJustificatif() {
        List<Justificatif> justificatifs=justificatifRepository.findAllJustificatifByStatut(true);
        List<JustificatifDto> dtos=new ArrayList<>();
        justificatifs.forEach(e->dtos.add(justificatifMapper.toDto(e)));
        return dtos;
    }

    @Override
    public ApiResponse UploadJustificatif(JustificatifDto justificatifDto) {
        Justificatif justificatif=justificatifMapper.toEntity(justificatifDto);
        justificatifRepository.save(justificatif);
        return ApiResponse.builder()
                .id(justificatif.getId())
                .message("Justiifcatif has been saved successfuly")
                .build();

    }

    @Override
    public ApiResponse deleteJustificatif(Long id) {
        Justificatif justificatif = justificatifRepository.findById(id).orElse(null);
        justificatif.setStatut(false);
        justificatifRepository.save(justificatif);
        return ApiResponse.builder()
                .id(justificatif.getId())
                .message("Justificatif has been deleted successfuly")
                .build();
    }
    }









