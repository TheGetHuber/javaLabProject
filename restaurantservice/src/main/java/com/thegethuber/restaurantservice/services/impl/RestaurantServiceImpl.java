package com.thegethuber.restaurantservice.services.impl;

import com.thegethuber.restaurantservice.dto.DishRequestDto;
import com.thegethuber.restaurantservice.dto.DishResponseDto;
import com.thegethuber.restaurantservice.dto.RestaurantRequestDto;
import com.thegethuber.restaurantservice.dto.RestaurantResponseDto;
import com.thegethuber.restaurantservice.entities.Dish;
import com.thegethuber.restaurantservice.entities.Restaurant;
import com.thegethuber.restaurantservice.exceptions.DishDoesNotExistsException;
import com.thegethuber.restaurantservice.exceptions.RestaurantDoesNotExistsException;
import com.thegethuber.restaurantservice.mappers.DishMapper;
import com.thegethuber.restaurantservice.mappers.RestaurantMapper;
import com.thegethuber.restaurantservice.repositories.DishRepository;
import com.thegethuber.restaurantservice.repositories.RestaurantRepository;
import com.thegethuber.restaurantservice.services.RestaurantService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {
    final RestaurantMapper restaurantMapper;
    final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponseDto createRestaurant(RestaurantRequestDto restaurantRequestDto){

        return restaurantMapper.toResponseDto(
                restaurantRepository.save(
                        restaurantMapper.toRestaurant(restaurantRequestDto)
                )
        );
    }
    @Override
    public RestaurantResponseDto updateRestaurant(Long restaurantId, RestaurantRequestDto restaurantRequestDto){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantDoesNotExistsException("Restaurant with this ID (" + restaurantId + ") does not exists!"));

        if(restaurantRequestDto.getName() != null){
            restaurant.setName(restaurantRequestDto.getName());
        }
        if(restaurantRequestDto.getCuisine() != null){
            restaurant.setCuisine(restaurantRequestDto.getCuisine());
        }
        if(restaurantRequestDto.getAddress() != null){
            restaurant.setAddress(restaurantRequestDto.getAddress());
        }

        return restaurantMapper.toResponseDto(
                restaurantRepository.save(restaurant)
        );
    }
    @Override
    @Transactional
    public void deleteRestaurant(Long restaurantId){
        if(!restaurantRepository.existsById(restaurantId)){
            throw new RestaurantDoesNotExistsException("Restaurant with this ID (" + restaurantId + ") does not exists!");
        }
        restaurantRepository.removeRestaurantById(restaurantId);
    }
    @Override
    public List<RestaurantResponseDto> listRestaurants(){
        return restaurantRepository.findAll()
               .stream()
               .map(restaurantMapper::toResponseDto)
               .collect(Collectors.toList());
    }
    @Override
    public RestaurantResponseDto getRestaurant(Long restaurantId){
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RestaurantDoesNotExistsException("Restaurant with this ID (" + restaurantId + ") does not exists!"));
        return restaurantMapper.toResponseDto(restaurant);
    }

    final DishRepository dishRepository;
    final DishMapper dishMapper;

    @Override
    public DishResponseDto addDish(DishRequestDto dishRequestDto){

        return dishMapper.toResponseDto(
                dishRepository.save(
                        dishMapper.toDish(dishRequestDto)
                )
        );
    }
    @Override
    public DishResponseDto updateDish(Long dishId, DishRequestDto dishRequestDto){
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new DishDoesNotExistsException("Dish with this ID (" + dishId + ") does not exists!"));

        if(dishRequestDto.getDescription() != null){
            dish.setDescription(dishRequestDto.getDescription());
        }
        if(dishRequestDto.getName() != null){
            dish.setName(dishRequestDto.getName());
        }
        if(dishRequestDto.getPrice() != null){
            dish.setPrice(dishRequestDto.getPrice());
        }
        if(dishRequestDto.getImageUrl() != null){
            dish.setImageUrl(dishRequestDto.getImageUrl());
        }

        return dishMapper.toResponseDto(
                dishRepository.save(dish)
        );
    }
    @Override
    @Transactional
    public void deleteDish(Long dishId){
        if(!dishRepository.existsById(dishId)){
            throw new DishDoesNotExistsException("Dish with this ID (" + dishId + ") does not exists!");
        }

        dishRepository.removeDishById(dishId);
    }
    @Override
    public DishResponseDto getDish(Long dishId){
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new DishDoesNotExistsException("Dish with this ID (" + dishId + ") does not exists!"));
        return dishMapper.toResponseDto(dish);
    }
    @Override
    public List<DishResponseDto> listDishesByRestaurant(Long restaurantId){
        return dishRepository.findAllByRestaurantId(restaurantId)
                .stream()
                .map(dishMapper::toResponseDto)
                .collect(Collectors.toList());
    }
    @Override
    public List<DishResponseDto> listDishes(){
        return dishRepository.findAll()
                .stream()
                .map(dishMapper::toResponseDto)
                .collect(Collectors.toList());
    }
}
