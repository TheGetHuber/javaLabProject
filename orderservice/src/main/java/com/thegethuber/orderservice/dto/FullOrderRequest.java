package com.thegethuber.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FullOrderRequest {
    private OrderRequestDto order;
    private List<OrderItemRequestDto> items;
}
