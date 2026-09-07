package com.cl.LibraryNetwork.mapper;


import com.cl.LibraryNetwork.dto.PublisherDTO;
import com.cl.LibraryNetwork.Entities.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublisherMapper {

    public PublisherDTO convertToDTO(Publisher entity) {
        if (entity == null) return null;
        return PublisherDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public List<PublisherDTO> convertToDTO(List<Publisher> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}