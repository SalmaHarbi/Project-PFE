package com.entreprise.msutilisateur.mappers;

import com.entreprise.msutilisateur.dtos.UserDtoRq;
import com.entreprise.msutilisateur.dtos.UserDtoRs;
import com.entreprise.msutilisateur.entities.Utilisateur;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UtilisateurMapper {

    @Mapping(target = "statut",defaultValue = "true")
    Utilisateur toEntity(UserDtoRq userDtoRq);

    UserDtoRq toDto(Utilisateur utilisateur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Utilisateur partialUpdate(UserDtoRq userDtoRq, @MappingTarget Utilisateur utilisateur);

    Utilisateur toEntity(UserDtoRs userDtoRs);

    @Mapping(target = "statut",defaultValue = "true")
    UserDtoRs toDtoRs(Utilisateur utilisateur);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Utilisateur partialUpdate(UserDtoRs userDtoRs,@MappingTarget Utilisateur utilisateur);
}