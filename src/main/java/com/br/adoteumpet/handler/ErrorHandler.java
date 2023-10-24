package com.br.adoteumpet.handler;

import com.br.adoteumpet.exceptions.NotFoundException;
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
    public ResponseEntity<ExceptionDto> conflictExceptionError409(ConflictException ex) {

        return new ResponseEntity<ExceptionDto>(new ExceptionDto(ex.getMessage(), 409), HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ InvalidRequestException.class })
    public ResponseEntity<ExceptionDto> invalidRequestExceptionError400(InvalidRequestException ex) {

        return new ResponseEntity<ExceptionDto>(new ExceptionDto(ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ NotFoundException.class })
    public ResponseEntity<ExceptionDto> notFoundExceptionError404(NotFoundException ex) {

        return new ResponseEntity<ExceptionDto>(new ExceptionDto(ex.getMessage(), 404), HttpStatus.NOT_FOUND);
    }
    
}
