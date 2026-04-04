package com.resume.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.resume.backend.model.Resume;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
}
