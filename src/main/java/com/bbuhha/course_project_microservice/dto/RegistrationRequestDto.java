package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Person;
import lombok.Data;

@Data
public class RegistrationRequestDto {
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String password;

    public Person toPerson() {

        return new Person(username, email, firstName, lastName, password);
    }
}
