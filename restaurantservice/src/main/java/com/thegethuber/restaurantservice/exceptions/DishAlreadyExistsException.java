package com.thegethuber.restaurantservice.exceptions;

public class DishAlreadyExistsException extends RuntimeException{
    public DishAlreadyExistsException(String message){
        super(message);
    }
}
