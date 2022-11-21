package com.bbuhha.course_project_microservice.service.Impl;

import com.bbuhha.course_project_microservice.model.Note;
import com.bbuhha.course_project_microservice.repository.NoteRepository;
import com.bbuhha.course_project_microservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public void add(Note note) {
        noteRepository.save(note);
    }

    @Override
    public List<Note> findAll() {
        List<Note> result = noteRepository.findAll();
        return result;
    }

    @Override
    public Note findByName(String name) {
        Note result = noteRepository.findByName(name);
        return result;
    }

    @Override
    public Note findById(Long id) {
        Optional<Note> result = noteRepository.findById(id);
        return result.get();
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);
    }
}
