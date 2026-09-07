package com.cl.LibraryNetwork.mapper;


import com.cl.LibraryNetwork.Entities.Fine;
import com.cl.LibraryNetwork.dto.FineDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FineMapper {

    public FineDTO convertToDTO(Fine entity) {
        if (entity == null) return null;
        return FineDTO.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .loanId(entity.getLoan() != null ? entity.getLoan().getId() : null)
                .build();
    }

    public List<FineDTO> convertToDTO(List<Fine> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}