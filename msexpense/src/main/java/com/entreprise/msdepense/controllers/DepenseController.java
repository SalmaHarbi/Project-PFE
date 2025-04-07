package com.entreprise.msdepense.controllers;


import com.entreprise.msdepense.dtos.ApiResponse;
import com.entreprise.msdepense.dtos.DepenseDto;
import com.entreprise.msdepense.services.serviceImpl.DepenseImpl;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/depense")
public class DepenseController {

    private final DepenseImpl depense;

    public DepenseController(DepenseImpl depense){
        this.depense=depense;
    }
    @GetMapping("/get/{id}")
    public DepenseDto getDepenseById(@PathVariable("id") Long id) {
        return depense.getById(id);
    }

    @GetMapping("/getAll")
    public List<DepenseDto> getAllDepenses() {
        return depense.getAllDepense();
    }

    @PostMapping("/add")
    public ApiResponse createDepense(@RequestBody DepenseDto depenseDto) {
        return depense.addDepense(depenseDto);
    }

    @PutMapping("/update/{id}")
    public ApiResponse updateDepense(@PathVariable("id") Long id, @RequestBody DepenseDto depenseDto) {
        return depense.updateDepense(id,depenseDto);
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteDepense(@PathVariable("id") Long id) {
        return depense.deleteDepense(id);
    }

    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }


}
