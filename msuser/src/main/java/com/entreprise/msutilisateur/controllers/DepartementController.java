package com.entreprise.msutilisateur.controllers;

import com.entreprise.msutilisateur.dtos.ApiResponse;
import com.entreprise.msutilisateur.dtos.DepDto;
import com.entreprise.msutilisateur.services.serviceinterfaces.DepartementService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dep")
public class DepartementController {

    private final DepartementService departementService;

    public DepartementController(DepartementService departementService){
        this.departementService=departementService;
    }

    @GetMapping("/get/{id}")
    public DepDto getDepById(@PathVariable("id") Long id) {
        return departementService.getById(id);
    }

    @GetMapping("/getAll")
    public List<DepDto> getAllUse() {
        return departementService.getAllDepartement();
    }

    @PostMapping("/add")
    public ApiResponse createDepartement(@RequestBody DepDto depDto) {
        return departementService.addDepartement(depDto);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateDepartement(@PathVariable("id") Long id, @RequestBody DepDto depDto) {
        return departementService.updateDepartement(id,depDto);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteDepartement(@PathVariable("id") Long id) {
        return departementService.deleteDepartement(id);
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}