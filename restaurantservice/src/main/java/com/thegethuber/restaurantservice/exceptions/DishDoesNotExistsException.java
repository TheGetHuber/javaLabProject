package com.thegethuber.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DishDoesNotExistsException extends RuntimeException{
    public DishDoesNotExistsException(String message){
        super(message);
    }
}
