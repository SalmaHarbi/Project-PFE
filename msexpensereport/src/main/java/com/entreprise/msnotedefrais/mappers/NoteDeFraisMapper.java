package com.entreprise.msnotedefrais.mappers;


import com.entreprise.msnotedefrais.dtos.NoteDeFraisDto;
import com.entreprise.msnotedefrais.entities.NoteDeFrais;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NoteDeFraisMapper {

    NoteDeFrais toEntity(NoteDeFraisDto noteDeFraisDto);

    NoteDeFraisDto toDto(NoteDeFrais noteDeFrais);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NoteDeFrais partialUpdate(NoteDeFraisDto noteDeFraisDto, @MappingTarget NoteDeFrais noteDeFrais);


}
