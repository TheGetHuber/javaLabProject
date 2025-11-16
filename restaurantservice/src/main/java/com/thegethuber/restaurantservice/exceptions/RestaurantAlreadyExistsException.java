package com.thegethuber.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT)
public class RestaurantAlreadyExistsException extends RuntimeException{
    public RestaurantAlreadyExistsException(String message){
        super(message);
    }
}
