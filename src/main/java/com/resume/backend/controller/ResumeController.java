package com.resume.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.resume.backend.model.Resume;
import com.resume.backend.service.ResumeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private ResumeService service;

    @PostMapping
    public ResponseEntity<Resume> create(@Valid @RequestBody Resume resume) {
        return ResponseEntity.ok(service.saveResume(resume));
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resume> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> update(@PathVariable Long id, @RequestBody Resume resume) {
        return ResponseEntity.ok(service.update(id, resume));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Deleted successfully");
    }
}