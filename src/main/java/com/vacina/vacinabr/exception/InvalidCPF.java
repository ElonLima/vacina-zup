package com.vacina.vacinabr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidCPF extends Exception {

    private static final long serialVersionUID = 1L;

    public InvalidCPF(String message){
        super(message);
    }
}
