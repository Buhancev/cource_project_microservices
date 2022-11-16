package com.bbuhha.course_project_microservice.rest;

import com.bbuhha.course_project_microservice.dto.AdminPersonDto;
import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/admin/")
public class AdminRestController
{

    private final PersonService personService;

    @Autowired
    public AdminRestController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping(value = "users/{id}")
    public ResponseEntity<AdminPersonDto> getUserById(@PathVariable(name = "id") Long id)
    {
        Person person = personService.findById(id);

        if (person == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminPersonDto result = AdminPersonDto.fromPerson(person);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}