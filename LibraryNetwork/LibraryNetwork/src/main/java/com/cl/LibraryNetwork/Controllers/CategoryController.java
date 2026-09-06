package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Category;
import com.cl.LibraryNetwork.Services.CategoryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Category create(@RequestBody Category entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @RequestBody Category entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}