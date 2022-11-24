package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Person;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistrationRequestDto {

    @NotBlank(message = "You didn't specify the username, or it's empty")
    private String username;

    @NotBlank(message = "You didn't specify the email, or it's empty")
    private String email;

    @NotBlank(message = "You didn't specify the first name, or it's empty")
    private String firstName;

    @NotBlank(message = "You didn't specify the last name, or it's empty")
    private String lastName;

    @NotBlank(message = "You didn't specify the password, or it's empty")
    private String password;

    public Person toPerson() {

        return new Person(username, email, firstName, lastName, password);
    }
}
