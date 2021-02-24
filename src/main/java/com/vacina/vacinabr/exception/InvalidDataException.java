package com.vacina.vacinabr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidDataException extends Exception{

    public static final long  serialVersionUID = 1L;

    public InvalidDataException(String message){
        super(message);
    }
}
