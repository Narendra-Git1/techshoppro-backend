package com.nari.techshoppro.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Order;
import com.nari.techshoppro.entity.Payment;

import com.nari.techshoppro.repository.OrderRepository;
import com.nari.techshoppro.repository.PaymentRepository;

import com.nari.techshoppro.service.PaymentService;

@Service
public class PaymentServiceImpl
        implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Payment processPayment(
            Long orderId,
            String paymentMethod) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow();

        Payment payment = new Payment();

        payment.setOrder(order);

        payment.setPaymentMethod(paymentMethod);

        payment.setPaymentStatus("SUCCESS");

        payment.setTransactionId(
                UUID.randomUUID().toString());

        // Update order payment status
        order.setPaymentStatus("PAID");

        orderRepository.save(order);

        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPaymentByOrder(Long orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow();

        return paymentRepository.findByOrder(order)
                .orElseThrow();
    }
}