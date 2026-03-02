package com.example.ekaterina_chervonenko_midterm.service;


import com.example.ekaterina_chervonenko_midterm.dto.StudentCreateDTO;
import com.example.ekaterina_chervonenko_midterm.dto.StudentResponseDTO;
import com.example.ekaterina_chervonenko_midterm.entities.Course;
import com.example.ekaterina_chervonenko_midterm.entities.Profile;
import com.example.ekaterina_chervonenko_midterm.entities.Student;
import com.example.ekaterina_chervonenko_midterm.repository.CourseRepository;
import com.example.ekaterina_chervonenko_midterm.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public void createStudent(StudentCreateDTO dto){
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        Profile profile = new Profile();
        profile.setBio(dto.getBio());
        student.setProfile(profile);

        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("курс не найден"));
        student.setCourse(course);

        studentRepository.save(student);
    }

    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    public StudentResponseDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("cтудент не найден"));
        return mapToResponseDTO(student);
    }

    private StudentResponseDTO mapToResponseDTO(Student student) {
        StudentResponseDTO res = new StudentResponseDTO();
        res.setId(student.getId());
        res.setName(student.getName());
        res.setEmail(student.getEmail());
        res.setBio(student.getProfile().getBio());
        res.setCourseTitle(student.getCourse().getTitle());
        return res;
    }
}