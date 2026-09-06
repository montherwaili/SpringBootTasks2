package com.cl.LibraryNetwork.Services;

import com.cl.LibraryNetwork.Entities.Reservation;
import com.cl.LibraryNetwork.Repositories.ReservationRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> getAll() { return repository.findAll(); }
    public Reservation getById(Long id) { return repository.findById(id).orElse(null); }
    public Reservation save(Reservation entity) { return repository.save(entity); }

    public Reservation update(Long id, Reservation entity) {
        if (repository.existsById(id)) {
            entity.setId(id);
            return repository.save(entity);
        }
        return null;
    }

    public void delete(Long id) { repository.deleteById(id); }
}