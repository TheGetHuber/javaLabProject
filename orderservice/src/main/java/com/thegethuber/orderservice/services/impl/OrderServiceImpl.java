package com.thegethuber.orderservice.services.impl;

import com.thegethuber.orderservice.dto.OrderItemRequestDto;
import com.thegethuber.orderservice.dto.OrderItemResponseDto;
import com.thegethuber.orderservice.dto.OrderRequestDto;
import com.thegethuber.orderservice.dto.OrderResponseDto;
import com.thegethuber.orderservice.entities.Order;
import com.thegethuber.orderservice.entities.OrderItem;
import com.thegethuber.orderservice.exceptions.OrderNotFoundException;
import com.thegethuber.orderservice.mappers.OrderItemMapper;
import com.thegethuber.orderservice.mappers.OrderMapper;
import com.thegethuber.orderservice.repositories.OrderItemRepository;
import com.thegethuber.orderservice.repositories.OrderRepository;
import com.thegethuber.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    final OrderRepository orderRepository;
    final OrderMapper orderMapper;
    final OrderItemMapper orderItemMapper;
    final OrderItemRepository orderItemRepository;

    @Override
    public OrderResponseDto placeOrder(OrderRequestDto orderRequestDto, List<OrderItemRequestDto> items){
        Order order = orderMapper.toOrder(orderRequestDto);
        order.setStatus("Not payed");
        OrderResponseDto orderResponseDto = orderMapper.toResponseDto(orderRepository.save(order));

        for(OrderItemRequestDto orderItemRequestDto : items){
            OrderItem item = orderItemMapper.toOrderItem(orderItemRequestDto);
            item.setOrderId(order.getId());
            orderItemRepository.save(item);
        }

        return orderResponseDto;
    }

    @Override
    public OrderResponseDto updateOrder(Long id, String status){
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new OrderNotFoundException("Order with given ID " + id + " was not found!")
        );

        order.setStatus(status);

        return orderMapper.toResponseDto(orderRepository.save(order));
    }

    @Override
    public OrderResponseDto getOrderById(Long id){
        return orderMapper.toResponseDto(
                orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order with given ID " + id + " was not found!"))
        );
    }
    @Override
    public List<OrderResponseDto> getOrderByUserId(Long id){
        return orderRepository.findAllByUserId(id);
    }
    @Override
    public List<OrderResponseDto> getOrdersByRestaurantId(Long restaurantId){
        return orderRepository.findAllByRestaurantId(restaurantId);
    }

    @Override
    public List<OrderItemResponseDto> getOrderItemsByOrderId(Long orderId){
        return orderItemRepository
                .findAllByOrderId(orderId)
                .stream()
                .map(orderItemMapper::toDto)
                .collect(Collectors.toList());
    }
}
