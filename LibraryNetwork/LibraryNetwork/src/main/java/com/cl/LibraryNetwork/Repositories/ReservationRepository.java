package com.cl.LibraryNetwork.Repositories;

import com.cl.LibraryNetwork.Entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {}