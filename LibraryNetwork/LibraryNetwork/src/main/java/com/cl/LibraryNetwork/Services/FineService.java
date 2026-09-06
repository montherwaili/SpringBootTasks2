package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Fine;
import com.cl.LibraryNetwork.Repositories.FineRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FineService {
    private final FineRepository repository;

    public FineService(FineRepository repository) {
        this.repository = repository;
    }

    public List<Fine> getAll() { return repository.findAll(); }
    public Fine getById(Long id) { return repository.findById(id).orElse(null); }
    public Fine save(Fine entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}