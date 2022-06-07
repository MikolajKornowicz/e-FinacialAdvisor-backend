package com.efinancialadvisor.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler {

    @ExceptionHandler
    public ResponseEntity<Object> handleTaskNotFoundException(BudgetNotFoundException exception){
        return new ResponseEntity<>("Budget with given user id does not exist", HttpStatus.BAD_REQUEST);
    }
}
