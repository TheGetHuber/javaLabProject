package com.thegethuber.orderservice.repositories;

import com.thegethuber.orderservice.dto.OrderResponseDto;
import com.thegethuber.orderservice.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOrderByUserId(Integer userId);

    List<Order> id(Long id);

    List<OrderResponseDto> findAllByUserId(Long userId);

    List<OrderResponseDto> findAllByRestaurantId(Long restaurantId);
}
