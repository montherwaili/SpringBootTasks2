package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Staff;
import com.cl.LibraryNetwork.Repositories.StaffRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StaffService {
    private final StaffRepository repository;

    public StaffService(StaffRepository repository) {
        this.repository = repository;
    }

    public List<Staff> getAll() { return repository.findAll(); }
    public Staff getById(Long id) { return repository.findById(id).orElse(null); }
    public Staff save(Staff entity) { return repository.save(entity); }

    public Staff update(Long id, Staff entity) {
        if (repository.existsById(id)) {
            entity.setId(id);
            return repository.save(entity);
        }
        return null;
    }

    public void delete(Long id) { repository.deleteById(id); }
}