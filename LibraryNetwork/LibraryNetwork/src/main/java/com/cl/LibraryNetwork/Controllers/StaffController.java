package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Staff;
import com.cl.LibraryNetwork.Services.StaffService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/staff")
public class StaffController {
    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }

    @GetMapping
    public List<Staff> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Staff getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Staff create(@RequestBody Staff entity) { return service.save(entity); }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}