package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.entity.CartItem;

public interface CartService {

    CartItem addToCart(
            Long userId,
            Long productId,
            Integer quantity);

    List<CartItem> getCartItems(Long userId);

    void removeCartItem(Long cartItemId);
}