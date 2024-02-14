package com.br.adoteumpet.service;

import com.br.adoteumpet.dto.pet.PetInputDto;
import com.br.adoteumpet.dto.pet.PetOutputDto;
import com.br.adoteumpet.exceptions.NotFoundException;
import com.br.adoteumpet.model.Pet;
import com.br.adoteumpet.repository.PetRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;

    }

    @Transactional
    public void save(Pet pet){
        petRepository.save(pet);
    }

    @Transactional
    public PetOutputDto update(UUID petId, PetInputDto pet){
        Optional<Pet> petUpdateOptional = petRepository.findById(petId);
        if(petUpdateOptional.isPresent()){
            Pet petUpdate = petUpdateOptional.get();
            petUpdate.setName(pet.getName());
            petUpdate.setColor(pet.getColor());
            petUpdate.setAge(pet.getAge());
            petRepository.save(petUpdate);
            return new PetOutputDto(petUpdate);
        }
        throw new NotFoundException("Pet not found.");
    }

    public List<PetOutputDto> findAll(){
        List<Pet> pets = petRepository.findAll();
        return PetOutputDto.listEntityToDto(pets);
    }

    public List<PetOutputDto> findPetsAvailableForAdoption(){
        List<Pet> pets = petRepository.findByStatusPet(true);
        return PetOutputDto.listEntityToDto(pets);
    }

}
