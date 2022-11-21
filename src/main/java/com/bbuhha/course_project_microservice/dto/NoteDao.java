package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Note;
import lombok.Data;

@Data
public class NoteDao {
    public String name;
    public String description;

    public Note toNote() {
        Note note = new Note();
        note.setName(name);
        note.setDescription(description);

        return note;
    }

    public static NoteDao fromBook(Note book) {
        NoteDao bookDao = new NoteDao();
        bookDao.setName(book.getName());
        bookDao.setDescription(book.getDescription());

        return bookDao;
    }
}
