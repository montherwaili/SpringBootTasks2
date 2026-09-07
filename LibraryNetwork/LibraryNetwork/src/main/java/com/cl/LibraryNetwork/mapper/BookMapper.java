package com.cl.LibraryNetwork.mapper;

import com.cl.LibraryNetwork.Entities.Book;
import com.cl.LibraryNetwork.dto.BookDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookMapper {

    public BookDTO convertToDTO(Book entity) {
        if (entity == null) return null;
        return BookDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .isbn(entity.getIsbn())
                .authorId(entity.getAuthor() != null ? entity.getAuthor().getId() : null)
                .categoryId(entity.getCategory() != null ? entity.getCategory().getId() : null)
                .publisherId(entity.getPublisher() != null ? entity.getPublisher().getId() : null)
                .build();
    }

    public List<BookDTO> convertToDTO(List<Book> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}