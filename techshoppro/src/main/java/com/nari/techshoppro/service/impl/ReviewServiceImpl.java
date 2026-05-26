package com.nari.techshoppro.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nari.techshoppro.entity.Product;
import com.nari.techshoppro.entity.Review;
import com.nari.techshoppro.entity.User;

import com.nari.techshoppro.repository.ProductRepository;
import com.nari.techshoppro.repository.ReviewRepository;
import com.nari.techshoppro.repository.UserRepository;

import com.nari.techshoppro.service.ReviewService;

@Service
public class ReviewServiceImpl
        implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Review addReview(
            Long userId,
            Long productId,
            Review review) {

        User user = userRepository.findById(userId)
                .orElseThrow();

        Product product =
                productRepository.findById(productId)
                        .orElseThrow();

        review.setUser(user);

        review.setProduct(product);

        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getProductReviews(Long productId) {

        Product product =
                productRepository.findById(productId)
                        .orElseThrow();

        return reviewRepository.findByProduct(product);
    }
}