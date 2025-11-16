package com.thegethuber.orderservice.mappers;

import com.thegethuber.orderservice.dto.PaymentRequestDto;
import com.thegethuber.orderservice.dto.PaymentResponseDto;
import com.thegethuber.orderservice.entities.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(target = "id", ignore = true)
    Payment toPayment(PaymentRequestDto paymentRequestDto);

    PaymentResponseDto toResponseDto(Payment payment);
}
