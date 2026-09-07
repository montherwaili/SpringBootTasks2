package com.cl.LibraryNetwork.mapper;


import com.cl.LibraryNetwork.Entities.Review;
import com.cl.LibraryNetwork.dto.ReviewDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewMapper {

    public ReviewDTO convertToDTO(Review entity) {
        if (entity == null) return null;
        return ReviewDTO.builder()
                .id(entity.getId())
                .comment(entity.getComment())
                .rating(entity.getRating())
                .memberId(entity.getMember() != null ? entity.getMember().getId() : null)
                .bookId(entity.getBook() != null ? entity.getBook().getId() : null)
                .build();
    }

    public List<ReviewDTO> convertToDTO(List<Review> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}