package com.bbuhha.course_project_microservice.service.Impl;

import com.bbuhha.course_project_microservice.model.Note;
import com.bbuhha.course_project_microservice.repository.NoteRepository;
import com.bbuhha.course_project_microservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    @Transactional
    public void saveOrUpdate(Note note) {
        noteRepository.save(note);
    }

    @Override
    @Transactional
    public List<Note> findAll(Long ownerId) {
        List<Note> result = noteRepository.findAllByOwnerId(ownerId);

        return result;
    }

    @Override
    @Transactional
    public Note findNoteByOwnerIdAndId(Long ownerId, Long noteId) {
        Note result = noteRepository.findNoteByOwnerIdAndId(ownerId, noteId);

        return result;
    }

    @Override
    @Transactional
    public void deleteNoteByOwnerIdAndId(Long ownerId, Long noteId) {
        noteRepository.deleteNoteByOwnerIdAndId(ownerId, noteId);
    }
}
