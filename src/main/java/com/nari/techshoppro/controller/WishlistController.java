package com.nari.techshoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.Wishlist;
import com.nari.techshoppro.service.WishlistService;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add")
    public Wishlist addToWishlist(

            @RequestParam Long userId,

            @RequestParam Long productId) {

        return wishlistService.addToWishlist(
                userId,
                productId);
    }

    @GetMapping("/{userId}")
    public List<Wishlist> getWishlist(
            @PathVariable Long userId) {

        return wishlistService.getWishlist(userId);
    }

    @DeleteMapping("/{id}")
    public String removeWishlistItem(
            @PathVariable Long id) {

        wishlistService.removeWishlistItem(id);

        return "Wishlist Item Removed";
    }
}