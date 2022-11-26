package com.bbuhha.course_project_microservice.repository;

import com.bbuhha.course_project_microservice.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    public List<Note> findAllByOwnerId(Long ownerId);

    public Note findNoteByOwnerIdAndId(Long ownerId, Long noteId);

    public void deleteNoteByOwnerIdAndId(Long ownerId, Long noteId);
}
