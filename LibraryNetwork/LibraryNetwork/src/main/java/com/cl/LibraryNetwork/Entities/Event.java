package com.cl.LibraryNetwork.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Event extends BaseClass {

    @Column(nullable = false, length = 150)
    private String title;

    @Column(name = "event_date", nullable = false)
    private LocalDateTime eventDate;

    @Column(columnDefinition = "TEXT")
    private String description;

}