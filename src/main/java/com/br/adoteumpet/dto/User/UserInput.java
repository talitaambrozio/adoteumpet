package com.br.adoteumpet.dto.User;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserInput(

        @NotBlank
        String name,
        @NotBlank
        String lastname,
        @NotBlank
        String email,
        @NotBlank
        @Size(min = 11, max = 13, message="must contain between 11 and 13 characters")
        String cellPhoneNumber,
        @NotBlank
        @Size(min = 11, max = 11, message="Size must be 11 characters")
        String cpf){}
