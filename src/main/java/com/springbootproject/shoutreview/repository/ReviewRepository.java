package com.springbootproject.shoutreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springbootproject.shoutreview.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {
    
     @Query(value = "select avg(rating) from review_table where movie_id=?",nativeQuery = true)
    Double getReviewAverage(Long id);
}
