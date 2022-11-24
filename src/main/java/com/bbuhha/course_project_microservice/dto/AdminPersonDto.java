package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AdminPersonDto {
    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String status;



    public Person toPerson() {
        Person person = new Person();
        person.setId(id);
        person.setUsername(username);
        person.setEmail(email);
        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setStatus(Status.valueOf(status));
        return person;
    }

    public static AdminPersonDto fromPerson(Person person) {
        AdminPersonDto adminUserDto = new AdminPersonDto();
        adminUserDto.setId(person.getId());
        adminUserDto.setUsername(person.getUsername());
        adminUserDto.setEmail(person.getEmail());
        adminUserDto.setFirstName(person.getFirstName());
        adminUserDto.setLastName(person.getLastName());
        adminUserDto.setStatus(person.getStatus().name());
        return adminUserDto;
    }
}