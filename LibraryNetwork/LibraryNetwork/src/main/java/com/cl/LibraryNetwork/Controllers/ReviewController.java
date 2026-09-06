package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Review;
import com.cl.LibraryNetwork.Services.ReviewService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping
    public List<Review> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Review create(@RequestBody Review entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public Review update(@PathVariable Long id, @RequestBody Review entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}