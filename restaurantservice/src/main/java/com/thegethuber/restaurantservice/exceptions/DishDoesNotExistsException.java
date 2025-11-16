package com.thegethuber.restaurantservice.exceptions;

public class DishDoesNotExistsException extends RuntimeException{
    public DishDoesNotExistsException(String message){
        super(message);
    }
}
