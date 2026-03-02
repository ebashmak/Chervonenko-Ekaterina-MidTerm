package com.example.ekaterina_chervonenko_midterm.repository;


import com.example.ekaterina_chervonenko_midterm.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Boolean existsByEmail(String email);
}
