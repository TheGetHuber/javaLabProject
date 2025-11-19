package com.thegethuber.orderservice.services;

import com.thegethuber.orderservice.dto.OrderItemRequestDto;
import com.thegethuber.orderservice.dto.OrderItemResponseDto;
import com.thegethuber.orderservice.dto.OrderRequestDto;
import com.thegethuber.orderservice.dto.OrderResponseDto;

import java.util.List;

public interface OrderService {
    OrderResponseDto placeOrder(OrderRequestDto orderRequestDto, List<OrderItemRequestDto> items);
    OrderResponseDto updateOrder(Long id, String status);
    OrderResponseDto getOrderById(Long id);
    List<OrderResponseDto> getOrderByUserId(Long id);
    List<OrderResponseDto> getOrdersByRestaurantId(Long restaurantId);

    List<OrderItemResponseDto> getOrderItemsByOrderId(Long orderId);
}