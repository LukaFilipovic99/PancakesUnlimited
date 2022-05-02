package com.lukafilipovic.PancakesUnlimitedApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException{
    String entity;
    public IdNotFoundException(String entity) {
        super(entity+" ID not found.");
    }
}
