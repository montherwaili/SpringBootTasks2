package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Author;
import com.cl.LibraryNetwork.Services.AuthorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorService service;

    public AuthorController(AuthorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Author> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Author getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Author create(@RequestBody Author entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public Author update(@PathVariable Long id, @RequestBody Author entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}