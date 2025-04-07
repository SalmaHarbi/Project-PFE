package com.entreprise.msutilisateur.services.serviceinterfaces;


import com.entreprise.msutilisateur.dtos.ApiResponse;
import com.entreprise.msutilisateur.dtos.UserDtoRq;
import com.entreprise.msutilisateur.dtos.UserDtoRs;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UtilisateurService {

    UserDtoRs getById(Long id);
    List<UserDtoRs> getAllUtilisateur();
    ApiResponse addUser(UserDtoRq userDtoRq);
    ApiResponse deleteUser(Long id);
    ApiResponse updateUser(Long id,UserDtoRq userDtoRq);
}
