package com.thegethuber.restaurantservice.repositories;

import com.thegethuber.restaurantservice.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface DishRepository extends JpaRepository<Dish, Long> {
    void removeDishById(Long id);

    Dish getDishById(Long id);

    Collection<Dish> findAllByRestaurantId(Long restaurantId);

    <T> CrudRepository<Dish, Long> findByRestaurantId(Long restaurantId);
}
