package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Book;
import com.cl.LibraryNetwork.Repositories.BookRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAll() { return repository.findAll(); }
    public Book getById(Long id) { return repository.findById(id).orElse(null); }
    public Book save(Book entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}