package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Book;
import com.cl.LibraryNetwork.Services.BookService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Book create(@RequestBody Book entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public Book update(@PathVariable Long id, @RequestBody Book entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}