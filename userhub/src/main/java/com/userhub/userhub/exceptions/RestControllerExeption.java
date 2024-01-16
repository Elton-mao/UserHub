package com.userhub.userhub.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class RestControllerExeption {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DefaultErro> handlerExeption(Exception e){
        DefaultErro error = new DefaultErro(HttpStatus.BAD_REQUEST.value(), e.getMessage());
        return ResponseEntity.ok().body(error);
    }

}
