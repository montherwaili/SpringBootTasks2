package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Reservation;
import com.cl.LibraryNetwork.Services.ReservationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    @GetMapping
    public List<Reservation> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Reservation getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Reservation create(@RequestBody Reservation entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public Reservation update(@PathVariable Long id, @RequestBody Reservation entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}