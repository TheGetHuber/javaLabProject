package com.thegethuber.restaurantservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RestaurantDoesNotExists extends RuntimeException{
    public RestaurantDoesNotExists(String message){
        super(message);
    }
}
