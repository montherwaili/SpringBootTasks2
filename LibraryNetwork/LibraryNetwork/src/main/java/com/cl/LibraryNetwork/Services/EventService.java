package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Event;
import com.cl.LibraryNetwork.Repositories.EventRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {
    private final EventRepository repository;

    public EventService(EventRepository repository) {
        this.repository = repository;
    }

    public List<Event> getAll() { return repository.findAll(); }
    public Event getById(Long id) { return repository.findById(id).orElse(null); }
    public Event save(Event entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}