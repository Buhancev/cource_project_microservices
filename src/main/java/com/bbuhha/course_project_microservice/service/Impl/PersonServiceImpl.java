package com.bbuhha.course_project_microservice.service.Impl;


import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Role;
import com.bbuhha.course_project_microservice.model.Status;
import com.bbuhha.course_project_microservice.repository.PersonRepository;
import com.bbuhha.course_project_microservice.repository.RoleRepository;
import com.bbuhha.course_project_microservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService
{
    private final PersonRepository personRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Lazy
    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, RoleRepository roleRepository,
                             BCryptPasswordEncoder passwordEncoder)
    {
        this.personRepository = personRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Person registration(Person person)
    {
        Role roleUser = roleRepository.findByName("ROLE_USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRoles(userRoles);
        person.setStatus(Status.ACTIVE);

        person.setCreated(new Date());
        person.setUpdated(new Date());

        Person registeredPerson = personRepository.save(person);

        log.info("IN register - user: {} successfully registered", registeredPerson);

        return registeredPerson;
    }

    @Override
    public List<Person> findAll()
    {
        List<Person> result = personRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public Person findByUsername(String username)
    {
        Person result = personRepository.findByUsername(username);
        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result;
    }

    @Override
    public Person findById(Long id)
    {

        Person result = personRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    @Override
    public void deleteById(Long id)
    {
        personRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }
}
