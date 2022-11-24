package com.bbuhha.course_project_microservice.rest;

import com.bbuhha.course_project_microservice.dto.AdminPersonDto;
import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Status;
import com.bbuhha.course_project_microservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminRestController
{
    private final PersonService personService;
    @Autowired
    public AdminRestController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<AdminPersonDto> getPersonById(@PathVariable(name = "id") Long id)
    {
        Person person = personService.findById(id);
        AdminPersonDto result = AdminPersonDto.fromPerson(person);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/ban/{id}")
    public ResponseEntity banPersonById(@PathVariable Long id) {
        Person person = personService.findById(id);
        person.setStatus(Status.DELETED);
        personService.update(person);

        return ResponseEntity.ok("Person with Id: " + id + " banned");
    }

    @GetMapping("/pardon/{id}")
    public ResponseEntity pardonPersonById(@PathVariable Long id) {
        Person person = personService.findById(id);
        person.setStatus(Status.ACTIVE);
        personService.update(person);

        return ResponseEntity.ok("Person with Id: " + id + " pardoned");
    }
}