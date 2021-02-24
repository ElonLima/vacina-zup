package com.vacina.vacinabr.exception;

public class InvalidEmail extends Exception {

    public static final long  serialVersionUID = 1L;

    public InvalidEmail(String message){
        super(message);
    }
}
