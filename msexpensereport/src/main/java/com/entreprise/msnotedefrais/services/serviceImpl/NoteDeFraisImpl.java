package com.entreprise.msnotedefrais.services.serviceImpl;

import com.entreprise.msnotedefrais.dtos.ApiResponse;
import com.entreprise.msnotedefrais.dtos.NoteDeFraisDto;
import com.entreprise.msnotedefrais.entities.NoteDeFrais;
import com.entreprise.msnotedefrais.mappers.NoteDeFraisMapper;
import com.entreprise.msnotedefrais.repositories.NoteDeFraisRepository;
import com.entreprise.msnotedefrais.services.serviceInterface.NoteDeFraisInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoteDeFraisImpl implements NoteDeFraisInterface {

    private final NoteDeFraisRepository noteDeFraisRepository;
    private final NoteDeFraisMapper noteDeFraisMapper;

    public NoteDeFraisImpl(NoteDeFraisRepository noteDeFraisRepository,NoteDeFraisMapper noteDeFraisMapper){
        this.noteDeFraisMapper=noteDeFraisMapper;
        this.noteDeFraisRepository=noteDeFraisRepository;
    }

    @Override
    public NoteDeFraisDto getById(Long id) {
        NoteDeFrais noteDeFrais= noteDeFraisRepository.findById(id).orElse(null);
        return noteDeFraisMapper.toDto(noteDeFrais);
    }

    @Override
    public List<NoteDeFraisDto> getAllNoteDeFrais() {
        List<NoteDeFrais> noteDeFrais=noteDeFraisRepository.findAllNoteDeFraisByStatut(true);
        List<NoteDeFraisDto> dtoNDF = new ArrayList<>();
        noteDeFrais.forEach(e->dtoNDF.add(noteDeFraisMapper.toDto(e)));
        return dtoNDF;
    }

    @Override
    public ApiResponse addNoteDeFrais(NoteDeFraisDto noteDeFraisDto) {
        NoteDeFrais noteDeFrais=noteDeFraisMapper.toEntity(noteDeFraisDto);
        noteDeFraisRepository.save(noteDeFrais);
        return ApiResponse.builder()
                .id(noteDeFrais.getId())
                .message("NoteDeFrais has been saved successfuly")
                .build();
    }

    @Override
    public ApiResponse deleteNoteDeFrais(Long id) {
        NoteDeFrais noteDeFrais = noteDeFraisRepository.findById(id).orElse(null);
        noteDeFrais.setStatutDisable(false);
        noteDeFraisRepository.save(noteDeFrais);
        return ApiResponse.builder()
                .id(noteDeFrais.getId())
                .message("Note de frais has been deleted successfuly")
                .build();
    }

    @Override
    public ApiResponse updateNoteDeFrais(Long id, NoteDeFraisDto noteDeFraisDto) {
        NoteDeFrais noteDeFrais= noteDeFraisRepository.findById(id).orElse(null);
        noteDeFraisMapper.partialUpdate(noteDeFraisDto,noteDeFrais);
        noteDeFraisRepository.save(noteDeFrais);
        return ApiResponse.builder()
                .id(noteDeFrais.getId())
                .message("Note de frais has been updated successfuly")
                .build();
    }
}
