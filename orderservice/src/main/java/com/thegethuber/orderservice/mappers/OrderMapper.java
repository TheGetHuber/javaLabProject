package com.thegethuber.orderservice.mappers;

import com.thegethuber.orderservice.dto.OrderRequestDto;
import com.thegethuber.orderservice.dto.OrderResponseDto;
import com.thegethuber.orderservice.entities.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    @Mapping(target = "id", ignore = true)
    Order toOrder(OrderRequestDto orderRequestDto);

    OrderResponseDto toResponseDto(Order order);
}
