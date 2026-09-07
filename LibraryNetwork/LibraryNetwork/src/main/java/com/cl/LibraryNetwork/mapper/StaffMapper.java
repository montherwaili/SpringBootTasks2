package com.cl.LibraryNetwork.mapper;


import com.cl.LibraryNetwork.Entities.Staff;
import com.cl.LibraryNetwork.dto.StaffDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StaffMapper {

    public StaffDTO convertToDTO(Staff entity) {
        if (entity == null) return null;
        return StaffDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .role(entity.getRole())
                .branchId(entity.getBranch() != null ? entity.getBranch().getId() : null)
                .build();
    }

    public List<StaffDTO> convertToDTO(List<Staff> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}