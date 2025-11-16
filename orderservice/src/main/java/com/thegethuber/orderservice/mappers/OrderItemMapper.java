package com.thegethuber.orderservice.mappers;

import com.thegethuber.orderservice.dto.OrderItemRequestDto;
import com.thegethuber.orderservice.dto.OrderItemResponseDto;
import com.thegethuber.orderservice.entities.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    @Mapping(target = "id", ignore = true)
    OrderItem toOrderItem(OrderItemRequestDto orderItemRequestDto);

    OrderItemResponseDto toDto(OrderItem orderItem);
}
