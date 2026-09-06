package com.cl.LibraryNetwork.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends BaseClass {

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(name = "total_copies", nullable = false)
    private Integer totalCopies;

    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies;

    @JsonIgnore
    @Builder.Default
    private List<Loan> loans = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}