package com.resume.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.resume.backend.model.Resume;
import com.resume.backend.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin(origins = "*")
public class ResumeController {

    @Autowired
    private ResumeService service;

    @PostMapping
    public Resume create(@RequestBody Resume resume) {
        return service.saveResume(resume);
    }

    @GetMapping
    public List<Resume> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Resume getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Resume update(@PathVariable Long id, @RequestBody Resume resume) {
        resume.setId(id);
        return service.saveResume(resume);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
