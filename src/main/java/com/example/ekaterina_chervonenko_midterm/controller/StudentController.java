package com.example.ekaterina_chervonenko_midterm.controller;


import com.example.ekaterina_chervonenko_midterm.dto.StudentCreateDTO;
import com.example.ekaterina_chervonenko_midterm.dto.StudentResponseDTO;
import com.example.ekaterina_chervonenko_midterm.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody StudentCreateDTO dto){
        studentService.createStudent(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body("студент успешно создан");
    }
    @GetMapping
    public ResponseEntity<List<StudentResponseDTO>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
}
