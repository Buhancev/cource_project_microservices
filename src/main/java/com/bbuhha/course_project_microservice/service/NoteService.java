package com.bbuhha.course_project_microservice.service;

import com.bbuhha.course_project_microservice.model.Note;

import java.util.List;

public interface NoteService {
    public void saveOrUpdate(Note note);

    public List<Note> findAll();

    public Note findByName(String name);

    public Note findById(Long id);

    public void deleteById(Long id);
}
