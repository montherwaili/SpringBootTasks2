package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Author;
import com.cl.LibraryNetwork.Repositories.AuthorRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public List<Author> getAll() { return repository.findAll(); }
    public Author getById(Long id) { return repository.findById(id).orElse(null); }
    public Author save(Author entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}