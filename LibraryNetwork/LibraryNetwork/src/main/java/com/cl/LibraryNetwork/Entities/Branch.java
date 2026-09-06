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
public class Branch extends BaseClass {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 255)
    private String location;

    @JsonIgnore
    @Builder.Default
    private List<Book> books = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Member> members = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Staff> staffMembers = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Event> events = new ArrayList<>();
}