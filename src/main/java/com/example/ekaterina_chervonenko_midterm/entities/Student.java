package com.example.ekaterina_chervonenko_midterm.entities;


import jakarta.persistence.*;
import lombok.Data;
@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}
