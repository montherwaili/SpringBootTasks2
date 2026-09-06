package com.cl.LibraryNetwork.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation extends BaseClass {

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false, length = 30)
    private String status;

}