package com.bbuhha.course_project_microservice.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class AuthenticationRequestDto {
    @NotBlank(message = "You didn't specify the username, or it's empty")
    private String username;

    @NotBlank(message = "You didn't specify the password, or it's empty")
    private String password;
}