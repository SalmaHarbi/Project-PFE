package com.entreprise.msutilisateur.controllers;

import com.entreprise.msutilisateur.dtos.ApiResponse;
import com.entreprise.msutilisateur.dtos.UserDtoRq;
import com.entreprise.msutilisateur.dtos.UserDtoRs;
import com.entreprise.msutilisateur.services.serviceinterfaces.UtilisateurService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UtilisateurController {

    private final UtilisateurService utilisateurService;

    public UtilisateurController(UtilisateurService utilisateurService){
         this.utilisateurService=utilisateurService;
    }

    @GetMapping("/get/{id}")
    public UserDtoRs getUserById(@PathVariable("id") Long id) {
        return utilisateurService.getById(id);
    }

    @GetMapping("/getAll")
    public List<UserDtoRs> getAllUsers() {
        return utilisateurService.getAllUtilisateur();
    }

    @PostMapping("/add")
    public ApiResponse createUser(@RequestBody UserDtoRq userDtoRq) {
        return utilisateurService.addUser(userDtoRq);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateUser(@PathVariable("id") Long id, @RequestBody UserDtoRq userDtoRq) {
        return utilisateurService.updateUser(id,userDtoRq);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteUser(@PathVariable("id") Long id) {
        return utilisateurService.deleteUser(id);
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }

}
