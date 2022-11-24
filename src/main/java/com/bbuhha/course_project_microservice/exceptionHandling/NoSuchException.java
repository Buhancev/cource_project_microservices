package com.bbuhha.course_project_microservice.exceptionHandling;

public class NoSuchException extends RuntimeException{
    public NoSuchException(String message) {
        super(message);
    }
}
