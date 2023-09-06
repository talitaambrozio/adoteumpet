package com.br.adoteumpet.dto;


import java.time.LocalDate;

public record RegistroUsuarioDto(

        String name,
        String lastname,
        String email,
        String cellPhoneNumber,
        String cpf){}
