package com.bbuhha.course_project_microservice.rest;

import com.bbuhha.course_project_microservice.dto.PersonDto;
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
@RequestMapping(value = "/api/users/")
public class PersonRestController
{
    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<PersonDto> getUserById(@PathVariable(name = "id") Long id)
    {
        Person person = personService.findById(id);

        if(person == null
        ){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        PersonDto result = PersonDto.fromPerson(person);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}