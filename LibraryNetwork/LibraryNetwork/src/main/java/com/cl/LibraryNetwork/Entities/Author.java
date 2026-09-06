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
public class Author extends BaseClass {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 60)
    private String nationality;

    @Column(columnDefinition = "TEXT")
    private String biography;

    @JsonIgnore
    @Builder.Default
    private List<Book> books = new ArrayList<>();
}