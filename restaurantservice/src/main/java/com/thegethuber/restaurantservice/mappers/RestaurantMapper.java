package com.thegethuber.restaurantservice.mappers;

import com.thegethuber.restaurantservice.dto.RestaurantRequestDto;
import com.thegethuber.restaurantservice.dto.RestaurantResponseDto;
import com.thegethuber.restaurantservice.entities.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    @Mapping(target = "id", ignore = true)
    Restaurant toRestaurant(RestaurantRequestDto restaurantRequestDto);

    RestaurantResponseDto toResponseDto(Restaurant restaurant);
}
