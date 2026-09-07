package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Review;
import com.cl.LibraryNetwork.Services.ReviewService;
import com.cl.LibraryNetwork.dto.ReviewDTO;
import com.cl.LibraryNetwork.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;

    @PostMapping
    public ReviewDTO createReview(@RequestBody Review review) {
        return reviewMapper.convertToDTO(reviewService.save(review));
    }

    @GetMapping
    public List<ReviewDTO> getAllReviews() {
        return reviewMapper.convertToDTO(reviewService.findAll());
    }

    @GetMapping("/{id}")
    public ReviewDTO getReviewById(@PathVariable Long id) {
        return reviewMapper.convertToDTO(reviewService.findById(id));
    }

    @PutMapping("/{id}")
    public ReviewDTO updateReview(@PathVariable Long id, @RequestBody Review review) {
        review.setId(id);
        return reviewMapper.convertToDTO(reviewService.save(review));
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteById(id);
    }
}