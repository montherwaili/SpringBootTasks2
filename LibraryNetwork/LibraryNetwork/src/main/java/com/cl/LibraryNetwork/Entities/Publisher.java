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
public class Publisher extends BaseClass {

    @Column(nullable = false, length = 120)
    private String name;

    @Column(length = 255)
    private String address;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @JsonIgnore
    @Builder.Default
    private List<Book> books = new ArrayList<>();
}