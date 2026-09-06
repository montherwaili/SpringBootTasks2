package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Loan;
import com.cl.LibraryNetwork.Services.LoanService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private final LoanService service;

    public LoanController(LoanService service) {
        this.service = service;
    }

    @GetMapping
    public List<Loan> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Loan getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Loan create(@RequestBody Loan entity) { return service.save(entity); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}