package com.cl.LibraryNetwork.mapper;


import com.cl.LibraryNetwork.Entities.Loan;
import com.cl.LibraryNetwork.dto.LoanDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LoanMapper {

    public LoanDTO convertToDTO(Loan entity) {
        if (entity == null) return null;
        return LoanDTO.builder()
                .id(entity.getId())
                .loanDate(entity.getLoanDate())
                .dueDate(entity.getDueDate())
                .memberId(entity.getMember() != null ? entity.getMember().getId() : null)
                .bookId(entity.getBook() != null ? entity.getBook().getId() : null)
                .build();
    }

    public List<LoanDTO> convertToDTO(List<Loan> entities) {
        return entities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}