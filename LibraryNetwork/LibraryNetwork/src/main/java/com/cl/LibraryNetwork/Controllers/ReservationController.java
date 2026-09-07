package com.cl.LibraryNetwork.Controllers;


import com.cl.LibraryNetwork.Entities.Reservation;
import com.cl.LibraryNetwork.Services.ReservationService;
import com.cl.LibraryNetwork.dto.ReservationDTO;
import com.cl.LibraryNetwork.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;
    private final ReservationMapper reservationMapper;

    @PostMapping
    public ReservationDTO createReservation(@RequestBody Reservation reservation) {
        return reservationMapper.convertToDTO(reservationService.save(reservation));
    }

    @GetMapping
    public List<ReservationDTO> getAllReservations() {
        return reservationMapper.convertToDTO(reservationService.findAll());
    }

    @GetMapping("/{id}")
    public ReservationDTO getReservationById(@PathVariable Long id) {
        return reservationMapper.convertToDTO(reservationService.findById(id));
    }

    @PutMapping("/{id}")
    public ReservationDTO updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation.setId(id);
        return reservationMapper.convertToDTO(reservationService.save(reservation));
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable Long id) {
        reservationService.deleteById(id);
    }
}