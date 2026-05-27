package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.entity.Wishlist;

public interface WishlistService {

    Wishlist addToWishlist(
            Long userId,
            Long productId);

    List<Wishlist> getWishlist(Long userId);

    void removeWishlistItem(Long id);
}