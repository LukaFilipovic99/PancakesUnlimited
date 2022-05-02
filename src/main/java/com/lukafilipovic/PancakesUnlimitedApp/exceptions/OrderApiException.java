package com.lukafilipovic.PancakesUnlimitedApp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OrderApiException extends RuntimeException{
    public OrderApiException() {
        super("Cannot add pancake to multiple orders.");
    }
}
