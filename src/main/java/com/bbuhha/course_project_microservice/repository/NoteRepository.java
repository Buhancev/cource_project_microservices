package com.bbuhha.course_project_microservice.repository;

import com.bbuhha.course_project_microservice.model.Note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    public Note findByName(String name);
}
