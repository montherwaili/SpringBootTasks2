package com.cl.LibraryNetwork.mapper;

import com.cl.LibraryNetwork.dto.BranchDTO;
import com.cl.LibraryNetwork.Entities.Branch;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BranchMapper {

    public BranchDTO convertToDTO(Branch entity) {
        if (entity == null) return null;
        return BranchDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .location(entity.getLocation())
                .build();
    }

    public List<BranchDTO> convertToDTO(List<Branch> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}