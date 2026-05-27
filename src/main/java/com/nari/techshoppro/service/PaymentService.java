package com.nari.techshoppro.service;

import com.nari.techshoppro.entity.Payment;

public interface PaymentService {

    Payment processPayment(
            Long orderId,
            String paymentMethod);

    Payment getPaymentByOrder(Long orderId);
}