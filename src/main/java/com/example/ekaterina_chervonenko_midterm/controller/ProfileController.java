package com.example.ekaterina_chervonenko_midterm.controller;

import com.example.ekaterina_chervonenko_midterm.entities.Profile;
import com.example.ekaterina_chervonenko_midterm.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/profiles")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileRepository profileRepository;

    @GetMapping
    public ResponseEntity<List<Profile>> getAll() {
        return ResponseEntity.ok(profileRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(profileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Профиль не найден")));
    }
}