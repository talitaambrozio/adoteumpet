package com.br.adoteumpet.exceptions;


public class ConflictException  extends RuntimeException{
    
    private String message;

    public ConflictException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
