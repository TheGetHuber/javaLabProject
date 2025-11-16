package com.thegethuber.restaurantservice.repositories;

import com.thegethuber.restaurantservice.dto.RestaurantResponseDto;
import com.thegethuber.restaurantservice.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    void removeRestaurantById(Long id);
}
