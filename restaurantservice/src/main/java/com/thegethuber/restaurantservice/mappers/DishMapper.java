package com.thegethuber.restaurantservice.mappers;

import com.thegethuber.restaurantservice.dto.DishRequestDto;
import com.thegethuber.restaurantservice.dto.DishResponseDto;
import com.thegethuber.restaurantservice.entities.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DishMapper {
    @Mapping(target = "id", ignore = true)
    Dish toDish(DishRequestDto dishRequestDto);

    DishResponseDto toResponseDto(Dish dish);
}