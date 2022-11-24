package com.bbuhha.course_project_microservice.service.Impl;

import com.bbuhha.course_project_microservice.exceptionHandling.NoSuchException;
import com.bbuhha.course_project_microservice.model.Note;
import com.bbuhha.course_project_microservice.repository.NoteRepository;
import com.bbuhha.course_project_microservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    @Transactional
    public void save(Note note) {
        note.setCreated(new Date());
        note.setUpdated(new Date());
        noteRepository.save(note);
    }

    @Override
    @Transactional
    public void update(Long ownerId, Long noteId, Note newNote) {
        Optional<Note> result = Optional.ofNullable(noteRepository.findNoteByOwnerIdAndId(ownerId, noteId));

        if(result.isEmpty()) {
            throw new NoSuchException("Error! There is nothing on the specified Note ID = " + noteId);
        }

        result.get().setName(newNote.getName());
        result.get().setDescription(newNote.getDescription());
        result.get().setUpdated(new Date());

        noteRepository.save(result.get());
    }

    @Override
    @Transactional
    public List<Note> findAll(Long ownerId) {
        Optional<List<Note>> result = Optional.ofNullable(noteRepository.findAllByOwnerId(ownerId));

        if(result.isEmpty() || result.get().isEmpty()) {
            throw new NoSuchException("You don't have any notes");
        }

        return result.get();
    }

    @Override
    @Transactional
    public Note findNoteByOwnerIdAndId(Long ownerId, Long noteId) {
        Optional<Note> result = Optional.ofNullable(noteRepository.findNoteByOwnerIdAndId(ownerId, noteId));

        if(result.isEmpty()) {
            throw new NoSuchException("Error! There is nothing on the specified Note ID = " + noteId);
        }

        return result.get();
    }

    @Override
    @Transactional
    public void deleteNoteByOwnerIdAndId(Long ownerId, Long noteId) {
        Optional<Note> result = Optional.ofNullable(noteRepository.findNoteByOwnerIdAndId(ownerId, noteId));

        if(result.isEmpty()) {
            throw new NoSuchException("Error! There is nothing on the specified Note ID = " + noteId);
        }

        noteRepository.deleteNoteByOwnerIdAndId(ownerId, noteId);
    }
}
