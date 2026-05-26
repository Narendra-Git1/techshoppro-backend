package com.nari.techshoppro.service;

import java.util.List;

import com.nari.techshoppro.entity.Review;

public interface ReviewService {

    Review addReview(
            Long userId,
            Long productId,
            Review review);

    List<Review> getProductReviews(Long productId);
}