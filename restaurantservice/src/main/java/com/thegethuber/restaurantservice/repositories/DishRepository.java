package com.thegethuber.restaurantservice.repositories;

import com.thegethuber.restaurantservice.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
    void removeDishById(Long id);

    Dish getDishById(Long id);
}
