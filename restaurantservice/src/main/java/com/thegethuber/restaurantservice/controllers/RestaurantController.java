package com.thegethuber.restaurantservice.controllers;

import com.thegethuber.restaurantservice.dto.DishRequestDto;
import com.thegethuber.restaurantservice.dto.DishResponseDto;
import com.thegethuber.restaurantservice.dto.RestaurantRequestDto;
import com.thegethuber.restaurantservice.dto.RestaurantResponseDto;
import com.thegethuber.restaurantservice.services.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    //region<GET MAPPERS>

    // get all restaurants
    @GetMapping("/list")
    public ResponseEntity<List<RestaurantResponseDto>> listRestaurants(){
        return ResponseEntity.ok(
                restaurantService.listRestaurants()
        );
    }
    // get restaurant by id
    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponseDto> getRestaurant(@PathVariable Long id){
        return ResponseEntity.ok(
                restaurantService.getRestaurant(id)
        );
    }
    // get all dishes from restaurant by id
    @GetMapping("/{restaurantId}/dishes")
    public ResponseEntity<List<DishResponseDto>> listDishes(@PathVariable Long restaurantId){
        return ResponseEntity.ok(
                restaurantService.listDishesByRestaurant(restaurantId)
        );
    }
    // get all dishes
    @GetMapping("/dishes")
    public ResponseEntity<List<DishResponseDto>> listDishes(){
        return ResponseEntity.ok(
                restaurantService.listDishes()
        );
    }
    // get dish by id
    @GetMapping("/dish/{dishId}")
    public ResponseEntity<DishResponseDto> getDish(@PathVariable Long dishId){
        return ResponseEntity.ok(
                restaurantService.getDish(dishId)
        );
    }
    // get dish by id from restaurant by id
    @GetMapping("/{restaurantId}/dish/{dishId}")
    public ResponseEntity<DishResponseDto> getDish(@PathVariable Long restaurantId, @PathVariable Long dishId){
        return ResponseEntity.ok(
                restaurantService.getDish(dishId)
        );
    }

    //endregion

    //region<POST MAPPERS>

    // create restaurant
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponseDto> createRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        return ResponseEntity.ok(restaurantService.createRestaurant(restaurantRequestDto));
    }
    // add dish to restaurant by id
    @PostMapping("/{id}/dishes")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DishResponseDto> addDish(@PathVariable Long id, @RequestBody DishRequestDto dishRequestDto) {
        return ResponseEntity.ok(restaurantService.addDish(dishRequestDto));
    }
    //endregion

    //region <PUT MAPPERS>

    // update dish by id from restaurant by id
    @PutMapping("/{id}/dishes/{dishId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<DishResponseDto> updateDish(@PathVariable Long id, @PathVariable Long dishId, @RequestBody DishRequestDto dishRequestDto) {
        return ResponseEntity.ok(restaurantService.updateDish(dishId, dishRequestDto));
    }
    // update restaurant
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RestaurantResponseDto> updateRestaurant(@PathVariable Long id, @RequestBody RestaurantRequestDto restaurantRequestDto) {
        return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurantRequestDto));
    }
    //endregion

    //region<DELETE MAPPERS>

    // delete restaurant by id
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.noContent().build();
    }

    // delete dish by id from restaurant by id
    @DeleteMapping("/{id}/dishes/{dishId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteDish(@PathVariable Long id, @PathVariable Long dishId) {
        restaurantService.deleteDish(dishId);
        return ResponseEntity.noContent().build();
    }
    //endregion
}
