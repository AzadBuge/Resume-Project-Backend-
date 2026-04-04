package com.resume.backend.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.resume.backend.model.Resume;
import com.resume.backend.repository.ResumeRepository;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository repo;

    public Resume saveResume(Resume resume) {
        return repo.save(resume);
    }

    public List<Resume> getAll() {
        return repo.findAll();
    }

    public Resume getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
