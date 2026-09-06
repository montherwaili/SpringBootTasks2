package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Loan;
import com.cl.LibraryNetwork.Repositories.LoanRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LoanService {
    private final LoanRepository repository;

    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> getAll() { return repository.findAll(); }
    public Loan getById(Long id) { return repository.findById(id).orElse(null); }
    public Loan save(Loan entity) { return repository.save(entity); }
    public void delete(Long id) { repository.deleteById(id); }
}