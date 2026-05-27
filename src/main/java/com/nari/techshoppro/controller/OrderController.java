package com.nari.techshoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.Order;
import com.nari.techshoppro.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/place")
    public Order placeOrder(
            @RequestParam Long userId) {

        return orderService.placeOrder(userId);
    }

    @GetMapping("/{userId}")
    public List<Order> getMyOrders(
            @PathVariable Long userId) {

        return orderService.getMyOrders(userId);
    }
}