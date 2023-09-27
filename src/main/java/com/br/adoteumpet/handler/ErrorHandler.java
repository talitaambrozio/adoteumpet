package com.br.adoteumpet.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.br.adoteumpet.dto.exceptions.ExceptionDto;
import com.br.adoteumpet.exceptions.ConflictException;
import com.br.adoteumpet.exceptions.InvalidRequestException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler({ ConflictException.class })
    public ResponseEntity<ExceptionDto> erroConflitoExcecaoErro409(ConflictException ex) {

        return new ResponseEntity<ExceptionDto>(new ExceptionDto(ex.getMessage(), 409), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ InvalidRequestException.class })
    public ResponseEntity<ExceptionDto> erroConflitoExcecaoErro409(InvalidRequestException ex) {

        return new ResponseEntity<ExceptionDto>(new ExceptionDto(ex.getMessage(), 400), HttpStatus.CONFLICT);
    }
    
}
