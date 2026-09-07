package com.cl.LibraryNetwork.mapper;

import com.cl.LibraryNetwork.dto.AuthorDTO;
import com.cl.LibraryNetwork.Entities.Author;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorMapper {

    public AuthorDTO convertToDTO(Author entity) {
        if (entity == null) return null;
        return AuthorDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .bio(entity.getBiography())
                .build();
    }

    public List<AuthorDTO> convertToDTO(List<Author> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}