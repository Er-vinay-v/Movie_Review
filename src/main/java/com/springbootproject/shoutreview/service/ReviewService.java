package com.springbootproject.shoutreview.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.shoutreview.domain.Movie;
import com.springbootproject.shoutreview.domain.Review;
import com.springbootproject.shoutreview.repository.MovieRepository;
import com.springbootproject.shoutreview.repository.ReviewRepository;
import com.springbootproject.shoutreview.service.response.ReviewResponse;

@Service
public class ReviewService {
    
      @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieRepository movieRepository;

    public void addReview(Review review) {
        Movie movie=movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        //need to optimized
        //exception handling.
        if(movie!=null) {
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }

    }

    public ReviewResponse getReviewById(Long reviewId) {

        Optional<Review> review= reviewRepository.findById(reviewId);
        return review.map(Review::toReviewResponse).orElse(null);

    }
}
