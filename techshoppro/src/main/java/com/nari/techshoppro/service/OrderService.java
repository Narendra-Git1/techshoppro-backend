package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.entity.Order;

public interface OrderService {

    Order placeOrder(Long userId);

    List<Order> getMyOrders(Long userId);
}