package com.nari.techshoppro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Cart;
import com.nari.techshoppro.entity.CartItem;
import com.nari.techshoppro.entity.Product;
import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.repository.CartItemRepository;
import com.nari.techshoppro.repository.CartRepository;
import com.nari.techshoppro.repository.ProductRepository;
import com.nari.techshoppro.repository.UserRepository;
import com.nari.techshoppro.service.CartService;

@Service
public class CartServiceImpl
        implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public CartItem addToCart(
            Long userId,
            Long productId,
            Integer quantity) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Product product =
                productRepository.findById(productId)
                        .orElseThrow();

        Cart cart = cartRepository.findByUser(user)
                .orElseGet(() -> {

                    Cart newCart = new Cart();

                    newCart.setUser(user);

                    return cartRepository.save(newCart);
                });

        CartItem cartItem = new CartItem();

        cartItem.setCart(cart);

        cartItem.setProduct(product);

        cartItem.setQuantity(quantity);

        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItems(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Cart cart = cartRepository.findByUser(user)
                .orElseThrow();

        return cartItemRepository.findByCart(cart);
    }

    @Override
    public void removeCartItem(Long cartItemId) {

        cartItemRepository.deleteById(cartItemId);
    }
}