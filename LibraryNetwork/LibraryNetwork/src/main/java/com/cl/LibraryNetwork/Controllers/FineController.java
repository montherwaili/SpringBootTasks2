package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Fine;
import com.cl.LibraryNetwork.Services.FineService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fines")
public class FineController {
    private final FineService service;

    public FineController(FineService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fine> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Fine getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Fine create(@RequestBody Fine entity) { return service.save(entity); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}