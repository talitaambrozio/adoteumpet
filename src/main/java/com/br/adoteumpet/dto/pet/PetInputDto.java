package com.br.adoteumpet.dto.pet;

import com.br.adoteumpet.model.Pet;
import com.br.adoteumpet.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetInputDto {

    @NotBlank
    private String name;
    @NotBlank
    private String race;
    @NotBlank
    private String color;
    @NotBlank
    private int age;

}
