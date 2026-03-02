package com.example.ekaterina_chervonenko_midterm.dto;

import lombok.Data;

@Data
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String bio;
    private String courseTitle;
}