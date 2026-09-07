package com.cl.LibraryNetwork.mapper;

import com.cl.LibraryNetwork.Entities.Reservation;
import com.cl.LibraryNetwork.dto.ReservationDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationMapper {

    public ReservationDTO convertToDTO(Reservation entity) {
        if (entity == null) return null;
        return ReservationDTO.builder()
                .id(entity.getId())
                .reservationDate(entity.getReservationDate())
                .memberId(entity.getMember() != null ? entity.getMember().getId() : null)
                .bookId(entity.getBook() != null ? entity.getBook().getId() : null)
                .build();
    }

    public List<ReservationDTO> convertToDTO(List<Reservation> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}