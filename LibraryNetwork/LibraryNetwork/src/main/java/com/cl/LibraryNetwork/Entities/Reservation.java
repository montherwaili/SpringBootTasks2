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
@SQLDelete(sql = "UPDATE reservations SET is_active = false WHERE id = ?")
@SQLRestriction("is_active = true")
public class Reservation extends BaseClass {

    @Column(name = "reservation_date", nullable = false)
    private LocalDateTime reservationDate;

    @Column(nullable = false, length = 30)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}