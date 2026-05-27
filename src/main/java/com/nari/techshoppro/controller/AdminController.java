package com.nari.techshoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.Order;
import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.service.OrderService;
import com.nari.techshoppro.service.ProductService;
import com.nari.techshoppro.service.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    // GET ALL USERS
    @GetMapping("/users")
    public List<User> getAllUsers() {

        return userService.getAllUsersForAdmin();
    }

    // GET ALL ORDERS
    @GetMapping("/orders")
    public List<Order> getAllOrders() {

        return orderService.getAllOrders();
    }

    // DELETE PRODUCT
    @DeleteMapping("/products/{id}")
    public String deleteProduct(
            @PathVariable Long id) {

        productService.deleteProduct(id);

        return "Product Deleted Successfully";
    }
}