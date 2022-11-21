package com.bbuhha.course_project_microservice.rest;

import com.bbuhha.course_project_microservice.dto.NoteDao;
import com.bbuhha.course_project_microservice.model.Note;
import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Status;
import com.bbuhha.course_project_microservice.service.NoteService;
import com.bbuhha.course_project_microservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/vault")
@Slf4j
public class NoteRestController {

    @Autowired
    NoteService noteService;

    @Autowired
    PersonService personService;


    @GetMapping("/notes")
    public List<NoteDao> getAllNotes(Principal principal) {
        Person owner = personService.findByUsername(principal.getName());

        List<Note> notes = owner.getNotes();

        List<NoteDao> result = new ArrayList<>();
        for(Note n : notes) {
            result.add(NoteDao.fromNote(n));
        }

        return result;
    }

    @PostMapping("/notes")
    public void createNote(Principal principal, @RequestBody NoteDao noteDao) {
        Note newNote = noteDao.toNote();

        newNote.setCreated(new Date());
        newNote.setUpdated(new Date());

        newNote.setStatus(Status.ACTIVE);

        Person owner = personService.findByUsername(principal.getName());

        newNote.setOwner(owner);

        noteService.saveOrUpdate(newNote);
    }
}
