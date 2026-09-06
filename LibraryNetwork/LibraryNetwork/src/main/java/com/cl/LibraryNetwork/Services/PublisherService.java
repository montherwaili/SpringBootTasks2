package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Publisher;
import com.cl.LibraryNetwork.Repositories.PublisherRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PublisherService {
    private final PublisherRepository repository;

    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public List<Publisher> getAll() { return repository.findAll(); }
    public Publisher getById(Long id) { return repository.findById(id).orElse(null); }
    public Publisher save(Publisher entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}