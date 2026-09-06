package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Branch;
import com.cl.LibraryNetwork.Services.BranchService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
    private final BranchService service;

    public BranchController(BranchService service) {
        this.service = service;
    }

    @GetMapping
    public List<Branch> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Branch getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Branch create(@RequestBody Branch entity) { return service.save(entity); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}