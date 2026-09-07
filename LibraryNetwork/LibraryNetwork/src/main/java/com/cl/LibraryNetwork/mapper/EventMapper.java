package com.cl.LibraryNetwork.mapper;

import com.cl.LibraryNetwork.Entities.Event;
import com.cl.LibraryNetwork.dto.EventDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EventMapper {

    public EventDTO convertToDTO(Event entity) {
        if (entity == null) return null;
        return EventDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .eventDate(entity.getEventDate())
                .branchId(entity.getBranch() != null ? entity.getBranch().getId() : null)
                .build();
    }

    public List<EventDTO> convertToDTO(List<Event> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}