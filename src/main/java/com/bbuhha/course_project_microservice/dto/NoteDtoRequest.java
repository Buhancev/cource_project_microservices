package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Note;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class NoteDtoRequest {
    @NotBlank(message = "You didn't specify the name, or it's empty")
    private String name;

    @NotBlank(message = "You didn't provide a description, or it's empty")
    private String description;

    public Note toNote(){
        Note note = new Note();
        note.setName(name);
        note.setDescription(description);

        return note;
    }

    public static NoteDtoRequest fromNote(Note note) {
        NoteDtoRequest noteDto = new NoteDtoRequest();
        noteDto.setName(note.getName());
        noteDto.setDescription(note.getDescription());

        return noteDto;
    }
}