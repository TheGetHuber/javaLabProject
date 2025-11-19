package com.thegethuber.orderservice.controllers;

import com.thegethuber.orderservice.dto.*;
import com.thegethuber.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    //region<GET MAPPING>

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long id){
        return ResponseEntity.ok(
                orderService.getOrderById(id)
        );
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<List<OrderResponseDto>> getOrderByUserId(@PathVariable Long id){
        return ResponseEntity.ok(
                orderService.getOrderByUserId(id)
        );
    }
    @GetMapping("/restaurants/{id}")
    public ResponseEntity<List<OrderResponseDto>> getOrdersByRestaurantId(@PathVariable Long id){
        return ResponseEntity.ok(
                orderService.getOrdersByRestaurantId(id)
        );
    }

    @GetMapping("/{id}/orderitem")
    public ResponseEntity<List<OrderItemResponseDto>> getOrderItemsByOrderId(@PathVariable Long id){
        return ResponseEntity.ok(
                orderService.getOrderItemsByOrderId(id)
        );
    }

    //endregion

    //region<POST MAPPERS>

    @PostMapping("")
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody FullOrderRequest fullOrderRequest){
        OrderRequestDto orderRequestDto = fullOrderRequest.getOrder();
        List<OrderItemRequestDto> orderItemRequestDtoList = fullOrderRequest.getItems();

        return ResponseEntity.ok(
                orderService.placeOrder(
                        orderRequestDto,
                        orderItemRequestDtoList
                )
        );
    }

    //endregion
}
