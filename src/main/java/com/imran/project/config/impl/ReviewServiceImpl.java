package com.imran.project.config.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.project.config.models.Review;
import com.imran.project.config.repository.ReviewRepository;
import com.imran.project.config.services.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	public Review addReview(Review review) {
		return this.reviewRepository.save(review);
	}

	public List<Review> findByProductId(Long productId) {
		return this.reviewRepository.findByProductId(productId);
	}

	/**
	 * @param ProductId
	 */
	public List<Review> showProductReview(Long productId) {
		return this.reviewRepository.findAllById(productId);
	}

	public List<Review> findAll() {
		return this.reviewRepository.findAll();
	}

	/**
	 *
	 */
	public List<Review> findAllReviews() {
		return this.reviewRepository.findAllReviews();
	}

	public void save(Review review) {
		this.reviewRepository.save(review);
	}

}
