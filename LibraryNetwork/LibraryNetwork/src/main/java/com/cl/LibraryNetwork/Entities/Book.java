package com.cl.LibraryNetwork.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE books SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
public class Book extends BaseClass {

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(name = "total_copies", nullable = false)
    private Integer totalCopies;

    @Column(name = "available_copies", nullable = false)
    private Integer availableCopies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<Loan> loans = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}