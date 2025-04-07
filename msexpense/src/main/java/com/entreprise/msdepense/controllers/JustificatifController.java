package com.entreprise.msdepense.controllers;

import com.entreprise.msdepense.dtos.ApiResponse;
import com.entreprise.msdepense.dtos.JustificatifDto;
import com.entreprise.msdepense.services.serviceImpl.JustificatifImpl;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/justif")
public class JustificatifController {

    private final JustificatifImpl justificatif;

    public JustificatifController(JustificatifImpl justificatif){
        this.justificatif=justificatif;
    }
    @GetMapping("/get/{id}")
    public JustificatifDto getJustificatifById(@PathVariable("id") Long id) {
        return justificatif.getById(id);
    }

    @GetMapping("/getAll")
    public List<JustificatifDto> getAllJustificatif() {
        return justificatif.getAllJustificatif();
    }

    @PostMapping("/add")
    public ApiResponse uploadJustificatif(@RequestBody JustificatifDto justificatifDto) {
        return justificatif.UploadJustificatif(justificatifDto);
    }


    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteJustificatif(@PathVariable("id") Long id) {
        return justificatif.deleteJustificatif(id);
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }



}
