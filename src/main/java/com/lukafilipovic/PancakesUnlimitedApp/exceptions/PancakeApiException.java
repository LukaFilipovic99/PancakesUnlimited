package com.lukafilipovic.PancakesUnlimitedApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PancakeApiException extends RuntimeException{
    public PancakeApiException(String message) {
        super(message);
    }
}
