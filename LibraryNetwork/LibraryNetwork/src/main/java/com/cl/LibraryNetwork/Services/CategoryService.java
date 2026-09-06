package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Category;
import com.cl.LibraryNetwork.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAll() { return repository.findAll(); }
    public Category getById(Long id) { return repository.findById(id).orElse(null); }
    public Category save(Category entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}