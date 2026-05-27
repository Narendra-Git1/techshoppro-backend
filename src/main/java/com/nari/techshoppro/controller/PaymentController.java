package com.nari.techshoppro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.Payment;
import com.nari.techshoppro.service.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/process")
    public Payment processPayment(

            @RequestParam Long orderId,

            @RequestParam String paymentMethod) {

        return paymentService.processPayment(
                orderId,
                paymentMethod);
    }

    @GetMapping("/{orderId}")
    public Payment getPaymentByOrder(
            @PathVariable Long orderId) {

        return paymentService
                .getPaymentByOrder(orderId);
    }
}