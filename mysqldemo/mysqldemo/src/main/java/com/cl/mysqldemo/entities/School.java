package com.cl.mysqldemo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Student> students = new ArrayList<>();

    private Boolean isActive;
    private Date createdDate;
    private Date updatedDate;
}