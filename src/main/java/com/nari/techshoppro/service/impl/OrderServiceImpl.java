package com.nari.techshoppro.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Cart;
import com.nari.techshoppro.entity.CartItem;
import com.nari.techshoppro.entity.Order;
import com.nari.techshoppro.entity.OrderItem;
import com.nari.techshoppro.entity.User;

import com.nari.techshoppro.repository.CartItemRepository;
import com.nari.techshoppro.repository.CartRepository;
import com.nari.techshoppro.repository.OrderItemRepository;
import com.nari.techshoppro.repository.OrderRepository;
import com.nari.techshoppro.repository.UserRepository;

import com.nari.techshoppro.service.OrderService;

@Service
public class OrderServiceImpl
        implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Order placeOrder(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow();

        List<CartItem> cartItems =
                cartItemRepository.findByCart(cart);

        Order order = new Order();

        order.setUser(user);

        order.setCreatedAt(LocalDateTime.now());

        order.setOrderStatus("PLACED");

        order.setPaymentStatus("PENDING");

        double totalAmount = 0;

        Order savedOrder =
                orderRepository.save(order);

        for (CartItem cartItem : cartItems) {

            OrderItem orderItem = new OrderItem();

            orderItem.setOrder(savedOrder);

            orderItem.setProduct(
                    cartItem.getProduct());

            orderItem.setQuantity(
                    cartItem.getQuantity());

            double price =
                    cartItem.getProduct().getPrice();

            orderItem.setPrice(price);

            totalAmount +=
                    price * cartItem.getQuantity();

            orderItemRepository.save(orderItem);
        }

        savedOrder.setTotalAmount(totalAmount);

        orderRepository.save(savedOrder);

        return savedOrder;
    }

    @Override
    public List<Order> getMyOrders(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        return orderRepository.findByUser(user);
    }
    @Override
    public List<Order> getAllOrders() {

        return orderRepository.findAll();
    }
}