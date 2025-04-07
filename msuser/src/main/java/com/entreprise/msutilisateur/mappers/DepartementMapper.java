package com.entreprise.msutilisateur.mappers;

import com.entreprise.msutilisateur.dtos.DepDto;
import com.entreprise.msutilisateur.entities.Departement;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartementMapper {

    Departement toEntity(DepDto depDto);

    DepDto toDto(Departement departement);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Departement partialUpdate(DepDto depDto, @MappingTarget Departement departement);
}