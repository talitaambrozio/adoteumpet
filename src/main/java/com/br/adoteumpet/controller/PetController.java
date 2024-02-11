package com.br.adoteumpet.controller;

import com.br.adoteumpet.dto.pet.PetInputDto;
import com.br.adoteumpet.dto.pet.PetOutputDto;
import com.br.adoteumpet.model.Pet;
import com.br.adoteumpet.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<PetOutputDto>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(petService.findAll());
    }

    @PutMapping("{petId}")
    public ResponseEntity<PetOutputDto> update(@PathVariable UUID petId, @RequestBody PetInputDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(petService.update(petId, dto));
    }
}
