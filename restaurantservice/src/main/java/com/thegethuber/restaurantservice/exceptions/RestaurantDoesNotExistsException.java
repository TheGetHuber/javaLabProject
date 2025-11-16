package com.thegethuber.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestaurantDoesNotExistsException extends RuntimeException{
    public RestaurantDoesNotExistsException(String message){
        super(message);
    }
}
