package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Person;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PersonDto {
    private Long id;

    @NotBlank
    private String username;

    public Person toPerson(){
        Person person = new Person();
        person.setId(id);
        person.setUsername(username);

        return person;
    }

    public static PersonDto fromPerson(Person person) {
        PersonDto personDto = new PersonDto();
        personDto.setId(person.getId());
        personDto.setUsername(person.getUsername());

        return personDto;
    }
}