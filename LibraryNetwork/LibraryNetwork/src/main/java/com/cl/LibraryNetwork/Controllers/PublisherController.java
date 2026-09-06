package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Publisher;
import com.cl.LibraryNetwork.Services.PublisherService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {
    private final PublisherService service;

    public PublisherController(PublisherService service) {
        this.service = service;
    }

    @GetMapping
    public List<Publisher> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Publisher getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Publisher create(@RequestBody Publisher entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public Publisher update(@PathVariable Long id, @RequestBody Publisher entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}