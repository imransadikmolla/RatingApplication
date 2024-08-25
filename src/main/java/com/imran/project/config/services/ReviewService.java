package com.imran.project.config.services;

import java.util.List;

import com.imran.project.config.models.Review;

public interface ReviewService {
	public Review addReview(Review review);

	public List<Review> findByProductId(Long productId);

	public List<Review> showProductReview(Long productId);

	public List<Review> findAll();

	public List<Review> findAllReviews();

	public void save(Review review);

}
