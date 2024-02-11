package com.br.adoteumpet.dto.pet;

import com.br.adoteumpet.model.Pet;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PetOutputDto {

    private UUID petId;
    private String name;
    private String color;
    private int age;
    private UUID userId;


    public PetOutputDto(Pet pet) {
        this.petId = pet.getPetId();
        this.name = pet.getName();
        this.color = pet.getColor();
        this.age = pet.getAge();
        this.userId = pet.getUser().getUserId();

    }

    public static List<PetOutputDto> listEntityToDto(List<Pet> petList) {
        return petList.stream().map(PetOutputDto::new).collect(Collectors.toList());
    }
}
