package com.br.adoteumpet.exceptions;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class ConflictException  extends RuntimeException{
    
    private String message;

}
