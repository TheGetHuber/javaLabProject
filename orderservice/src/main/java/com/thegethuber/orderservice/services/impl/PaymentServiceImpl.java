package com.thegethuber.orderservice.services.impl;

import com.thegethuber.orderservice.repositories.PaymentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl {
    final PaymentRepository paymentRepository;
}
