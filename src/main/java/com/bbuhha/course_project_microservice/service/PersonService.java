package com.bbuhha.course_project_microservice.service;


import com.bbuhha.course_project_microservice.model.Person;

import java.util.List;

public interface PersonService
{
    public Person registration(Person person);

    List<Person> findAll();

    Person findByUsername(String username);

    Person findById(Long id);

    void deleteById(Long id);
}
