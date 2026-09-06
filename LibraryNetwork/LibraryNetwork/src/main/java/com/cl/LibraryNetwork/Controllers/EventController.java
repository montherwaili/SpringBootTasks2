package com.cl.LibraryNetwork.Controllers;

import com.cl.LibraryNetwork.Entities.Event;
import com.cl.LibraryNetwork.Services.EventService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<Event> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Event getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Event create(@RequestBody Event entity) { return service.save(entity); }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}