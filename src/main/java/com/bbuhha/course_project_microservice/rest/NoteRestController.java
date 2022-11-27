package com.bbuhha.course_project_microservice.rest;

import com.bbuhha.course_project_microservice.dto.NoteDtoRequest;
import com.bbuhha.course_project_microservice.dto.NoteDtoResponse;
import com.bbuhha.course_project_microservice.model.Note;
import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.service.NoteService;
import com.bbuhha.course_project_microservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/notes")
public class NoteRestController {

    private final PersonService personService;
    private final NoteService noteService;

    @Autowired
    public NoteRestController(PersonService personService, NoteService noteService) {
        this.personService = personService;
        this.noteService = noteService;
    }


    @GetMapping("/")
    public ResponseEntity getAllNodes(@ApiIgnore Principal principal) {
        Person owner =  personService.findByUsername(principal.getName());
        List<NoteDtoResponse> result = noteService.findAll(
                owner.getId()).stream()
                              .map(x -> NoteDtoResponse.fromNote(x))
                              .collect(Collectors.toList()
                              );

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{noteId}")
    public ResponseEntity getNodeById(@ApiIgnore Principal principal, @PathVariable Long noteId) {
        Person owner =  personService.findByUsername(principal.getName());
        Note result = noteService.findNoteByOwnerIdAndId(owner.getId(), noteId);
        return ResponseEntity.ok(NoteDtoResponse.fromNote(result));
    }


    @PostMapping("/note")
    public ResponseEntity createNote(@ApiIgnore Principal principal, @Valid @RequestBody NoteDtoRequest noteDto) {
        Person owner =  personService.findByUsername(principal.getName());
        Note newNote = noteDto.toNote();
        newNote.setOwner(owner);
        noteService.save(newNote);
        return ResponseEntity.ok(NoteDtoResponse.fromNote(newNote));
    }

    @PutMapping("/{noteId}")
    public ResponseEntity updateNote(@ApiIgnore Principal principal, @PathVariable Long noteId ,
                                     @Valid @RequestBody NoteDtoRequest noteDto) {
        Person owner =  personService.findByUsername(principal.getName());
        noteService.update(owner.getId(), noteId, noteDto.toNote());
        return ResponseEntity.ok("Note updated");
    }

    @DeleteMapping("/{noteId}")
    public ResponseEntity deleteNote(@ApiIgnore Principal principal, @PathVariable Long noteId) {
        Person owner =  personService.findByUsername(principal.getName());
        noteService.deleteNoteByOwnerIdAndId(owner.getId(), noteId);
        return ResponseEntity.ok("Note deleted");
    }
}
