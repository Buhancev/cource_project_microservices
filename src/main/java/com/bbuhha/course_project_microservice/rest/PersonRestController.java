package com.bbuhha.course_project_microservice.rest;

import com.bbuhha.course_project_microservice.dto.PersonDto;
import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/persons")
public class PersonRestController
{
    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService)
    {
        this.personService = personService;
    }
}