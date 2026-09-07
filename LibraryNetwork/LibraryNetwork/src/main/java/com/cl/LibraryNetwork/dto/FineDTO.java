package com.cl.LibraryNetwork.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FineDTO {
    private Long id;
    private Double amount;
    private Long loanId;
}