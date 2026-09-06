package com.cl.LibraryNetwork.Services;


import com.cl.LibraryNetwork.Entities.Branch;
import com.cl.LibraryNetwork.Repositories.BranchRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BranchService {
    private final BranchRepository repository;

    public BranchService(BranchRepository repository) {
        this.repository = repository;
    }

    public List<Branch> getAll() { return repository.findAll(); }
    public Branch getById(Long id) { return repository.findById(id).orElse(null); }
    public Branch save(Branch entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}