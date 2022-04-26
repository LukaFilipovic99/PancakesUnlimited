package com.lukafilipovic.PancakesUnlimitedApp.exceptions;

public class OrderApiException extends RuntimeException{
    public OrderApiException(String message) {
        super(message);
    }
}
