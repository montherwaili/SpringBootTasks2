package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Review;
import com.cl.LibraryNetwork.Repositories.ReviewRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {
    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> getAll() { return repository.findAll(); }
    public Review getById(Long id) { return repository.findById(id).orElse(null); }
    public Review save(Review entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}