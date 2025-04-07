package com.entreprise.msdepense.mappers;

import com.entreprise.msdepense.dtos.DepenseDto;
import com.entreprise.msdepense.entities.Depense;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepenseMapper {

    @Mapping(target = "statut",defaultValue = "true")
    Depense toEntity(DepenseDto depenseDto);

    DepenseDto toDto(Depense depense);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Depense partialUpdate(DepenseDto depenseDto, @MappingTarget Depense depense);
}