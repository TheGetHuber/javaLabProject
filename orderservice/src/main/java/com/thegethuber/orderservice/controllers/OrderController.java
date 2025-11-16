package com.thegethuber.orderservice.controllers;

import com.thegethuber.orderservice.dto.OrderRequestDto;
import com.thegethuber.orderservice.dto.OrderResponseDto;
import com.thegethuber.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderResponseDto> placeOrder(@RequestBody Map<String, Object> payload){
        // payload must contain: order list in JSON, items list in JSON
        // TODO: Make payload unwrapper
        // OrderRequestDto orderRequestDto =
    }
}
