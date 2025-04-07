package com.entreprise.msutilisateur.services.serviceimpl;

import com.entreprise.msutilisateur.dtos.ApiResponse;
import com.entreprise.msutilisateur.dtos.UserDtoRq;
import com.entreprise.msutilisateur.dtos.UserDtoRs;
import com.entreprise.msutilisateur.entities.Utilisateur;
import com.entreprise.msutilisateur.mappers.UtilisateurMapper;
import com.entreprise.msutilisateur.repositories.UtilisateurRepository;
import com.entreprise.msutilisateur.services.serviceinterfaces.UtilisateurService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;



    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository,UtilisateurMapper utilisateurMapper){
        this.utilisateurRepository=utilisateurRepository;
        this.utilisateurMapper=utilisateurMapper;
    }

    @Override
    public UserDtoRs getById(Long id) {
        Utilisateur utilisateur= utilisateurRepository.findById(id).orElse(null);
        return utilisateurMapper.toDtoRs(utilisateur);
    }

    @Override
    public List<UserDtoRs> getAllUtilisateur() {
       List<Utilisateur> utilisateurs=utilisateurRepository.findAllUtilisateurByStatut(true);
       List<UserDtoRs> dtoRs = new ArrayList<>();
       utilisateurs.forEach(e->dtoRs.add(utilisateurMapper.toDtoRs(e)));
       return dtoRs;
    }

    @Override
    public ApiResponse addUser(UserDtoRq userDtoRq) {
        Utilisateur utilisateur=utilisateurMapper.toEntity(userDtoRq);
        utilisateurRepository.save(utilisateur);
        return ApiResponse.builder()
                .id(utilisateur.getId())
                .message("User has been saved successfuly")
                .build();
    }

    @Override
    public ApiResponse deleteUser(Long id) {
     Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
     utilisateur.setStatut(false);
     utilisateurRepository.save(utilisateur);
     return ApiResponse.builder()
             .id(utilisateur.getId())
             .message("User has been deleted successfuly")
             .build();

    }

    @Override
    public ApiResponse updateUser(Long id,UserDtoRq userDtoRq) {
       Utilisateur utilisateur= utilisateurRepository.findById(id).orElse(null);
        utilisateurMapper.partialUpdate(userDtoRq,utilisateur);
       utilisateurRepository.save(utilisateur);
       return ApiResponse.builder()
               .id(utilisateur.getId())
               .message("User has been updated successfuly")
               .build();
    }
}
