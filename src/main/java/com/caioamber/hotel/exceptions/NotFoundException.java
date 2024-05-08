package com.caioamber.hotel.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
