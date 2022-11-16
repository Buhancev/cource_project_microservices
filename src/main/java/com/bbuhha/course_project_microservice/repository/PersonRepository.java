package com.bbuhha.course_project_microservice.repository;

import com.bbuhha.course_project_microservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>
{
    public Person findByUsername(String username);
}
