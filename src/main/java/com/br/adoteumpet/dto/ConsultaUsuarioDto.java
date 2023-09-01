package com.br.adoteumpet.dto;

import java.time.LocalDate;

public record ConsultaUsuarioDto(String nome, String sobrenome, LocalDate dataNascimento) {
}
