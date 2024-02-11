package com.br.adoteumpet.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvalidRequestException extends RuntimeException{
    
    private String message;

}
