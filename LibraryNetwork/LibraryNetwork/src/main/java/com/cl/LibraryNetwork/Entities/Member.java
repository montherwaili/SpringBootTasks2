package com.cl.LibraryNetwork.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends BaseClass {

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "membership_type", nullable = false, length = 30)
    private String membershipType;

    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    @JsonIgnore
    @Builder.Default
    private List<Loan> loans = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Reservation> reservations = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Fine> fines = new ArrayList<>();

    @JsonIgnore
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}