package com.bbuhha.course_project_microservice.service;

import com.bbuhha.course_project_microservice.model.Person;

import java.util.List;

public interface PersonService {

    public Person registration(Person person);

    public List<Person> findAll();

    public Person findById(Long id);

    public Person findByUsername(String username);

    public void deleteById(Long id);
}
