package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Note;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteDto {
    Long id;
    String name;
    String description;

    public Note toNote(){
        Note note = new Note();
        note.setId(id);
        note.setName(name);
        note.setDescription(description);

        return note;
    }

    public static NoteDto fromNote(Note note) {
        NoteDto noteDto = new NoteDto();
        noteDto.setId(note.getId());
        noteDto.setName(note.getName());
        noteDto.setDescription(note.getDescription());

        return noteDto;
    }
}
