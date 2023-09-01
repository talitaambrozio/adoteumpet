package com.br.adoteumpet.dto;


import java.time.LocalDate;

public record RegistroUsuarioDto(

        @NotNull
        String nome,
        String sobrenome,
        LocalDate dataNascimento,
        String cpf){}
