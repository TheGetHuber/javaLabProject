package com.thegethuber.restaurantservice.services;

import com.thegethuber.restaurantservice.dto.DishRequestDto;
import com.thegethuber.restaurantservice.dto.DishResponseDto;
import com.thegethuber.restaurantservice.dto.RestaurantRequestDto;
import com.thegethuber.restaurantservice.dto.RestaurantResponseDto;

import java.util.List;

public interface RestaurantService {
    RestaurantResponseDto createRestaurant(RestaurantRequestDto restaurantRequestDto);
    RestaurantResponseDto updateRestaurant(Long restaurantId, RestaurantRequestDto restaurantRequestDto);
    void deleteRestaurant(Long restaurantId);
    List<RestaurantResponseDto> listRestaurants();
    RestaurantResponseDto getRestaurant(Long restaurantId);

    DishResponseDto addDish(DishRequestDto dishRequestDto);
    DishResponseDto updateDish(Long dishId, DishRequestDto dishRequestDto);
    void deleteDish(Long dishId);
    DishResponseDto getDish(Long dishId);
}
