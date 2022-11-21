package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDao {
    private Long id;
    private String username;

    public Person toPerson(){
        Person person = new Person();
        person.setId(id);
        person.setUsername(username);

        return person;
    }

    public static PersonDao fromPerson(Person person) {
        PersonDao personDao = new PersonDao();
        personDao.setId(person.getId());
        personDao.setUsername(person.getUsername());

        return personDao;
    }
}