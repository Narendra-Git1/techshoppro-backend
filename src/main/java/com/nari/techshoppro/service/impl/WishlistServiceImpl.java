package com.nari.techshoppro.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Product;
import com.nari.techshoppro.entity.User;
import com.nari.techshoppro.entity.Wishlist;

import com.nari.techshoppro.repository.ProductRepository;
import com.nari.techshoppro.repository.UserRepository;
import com.nari.techshoppro.repository.WishlistRepository;

import com.nari.techshoppro.service.WishlistService;

@Service
public class WishlistServiceImpl
        implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Wishlist addToWishlist(
            Long userId,
            Long productId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Product product =
                productRepository.findById(productId)
                        .orElseThrow();

        Wishlist wishlist = new Wishlist();

        wishlist.setUser(user);

        wishlist.setProduct(product);

        return wishlistRepository.save(wishlist);
    }

    @Override
    public List<Wishlist> getWishlist(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        return wishlistRepository.findByUser(user);
    }

    @Override
    public void removeWishlistItem(Long id) {

        wishlistRepository.deleteById(id);
    }
}