package com.vacina.vacinabr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidEmail.class)
    public ResponseEntity<?> resourceNotFoundException (InvalidEmail notFoundException,
                                                        WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                notFoundException.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidCPF.class)
    public ResponseEntity<?> resourceNotFoundException (InvalidCPF notFoundException,
                                                        WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                notFoundException.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globalExceptionHandler (Exception globalException,
                                                     WebRequest request) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(),
                globalException.getMessage(),
                request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
