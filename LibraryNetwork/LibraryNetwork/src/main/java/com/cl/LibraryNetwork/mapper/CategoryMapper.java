package com.cl.LibraryNetwork.mapper;

import com.cl.LibraryNetwork.dto.CategoryDTO;
import com.cl.LibraryNetwork.Entities.Category;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public CategoryDTO convertToDTO(Category entity) {
        if (entity == null) return null;
        return CategoryDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    public List<CategoryDTO> convertToDTO(List<Category> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}