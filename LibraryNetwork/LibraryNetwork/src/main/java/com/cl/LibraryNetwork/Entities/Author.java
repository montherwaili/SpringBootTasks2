package com.cl.LibraryNetwork.Entities;



import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SQLDelete(sql = "UPDATE authors SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
public class Author extends BaseClass {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 60)
    private String nationality;

    @Column(columnDefinition = "TEXT")
    private String biography;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private List<Book> books = new ArrayList<>();
}