package com.nari.techshoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.CartItem;
import com.nari.techshoppro.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public CartItem addToCart(

            @RequestParam Long userId,

            @RequestParam Long productId,

            @RequestParam Integer quantity) {

        return cartService.addToCart(
                userId,
                productId,
                quantity);
    }

    @GetMapping("/{userId}")
    public List<CartItem> getCartItems(
            @PathVariable Long userId) {

        return cartService.getCartItems(userId);
    }

    @DeleteMapping("/remove/{cartItemId}")
    public String removeCartItem(
            @PathVariable Long cartItemId) {

        cartService.removeCartItem(cartItemId);

        return "Cart Item Removed Successfully";
    }
}