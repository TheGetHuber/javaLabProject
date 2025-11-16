package com.thegethuber.restaurantservice.controllers;

import com.thegethuber.restaurantservice.dto.RestaurantResponseDto;
import com.thegethuber.restaurantservice.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    @GetMapping("/list")
    public ResponseEntity<List<RestaurantResponseDto>> listRestaurants(){
        return ResponseEntity.ok(
                restaurantService.listRestaurants()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> getRestaurant(@PathVariable Long id){
        return ResponseEntity.ok(
            restaurantService.getRestaurant(id)
        );
    }
}
