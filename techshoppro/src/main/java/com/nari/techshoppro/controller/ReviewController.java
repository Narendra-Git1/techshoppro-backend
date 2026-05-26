package com.nari.techshoppro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.nari.techshoppro.entity.Review;
import com.nari.techshoppro.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/add")
    public Review addReview(

            @RequestParam Long userId,

            @RequestParam Long productId,

            @RequestBody Review review) {

        return reviewService.addReview(
                userId,
                productId,
                review);
    }

    @GetMapping("/product/{productId}")
    public List<Review> getProductReviews(
            @PathVariable Long productId) {

        return reviewService
                .getProductReviews(productId);
    }
}