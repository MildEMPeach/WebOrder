package org.mildempeach.service;

import org.mildempeach.entity.Review;
import org.mildempeach.mapper.ReviewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewService {
    @Autowired
    ReviewMapper reviewMapper;

    public void insertReview(Review review) {
        reviewMapper.insertReview(review);
    }

    public Review getReviewById(long instrumentid, long userid) {
        return reviewMapper.getReviewById(instrumentid, userid);
    }

    public List<Review> getReviewByInstrumentid(long instrumentid) {
        return reviewMapper.getReviewByInstrumentid(instrumentid);
    }

}
