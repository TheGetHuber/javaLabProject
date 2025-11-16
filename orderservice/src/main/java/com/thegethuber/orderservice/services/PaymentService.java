package com.thegethuber.orderservice.services;

import com.thegethuber.orderservice.dto.PaymentRequestDto;
import com.thegethuber.orderservice.dto.PaymentResponseDto;

public interface PaymentService {
    PaymentResponseDto proccessPayment(PaymentRequestDto paymentRequestDto);
}
