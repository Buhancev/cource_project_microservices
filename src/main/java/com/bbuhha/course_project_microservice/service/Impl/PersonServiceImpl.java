package com.bbuhha.course_project_microservice.service.Impl;


import com.bbuhha.course_project_microservice.exceptionHandling.NoSuchException;
import com.bbuhha.course_project_microservice.model.Note;
import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Role;
import com.bbuhha.course_project_microservice.model.Status;
import com.bbuhha.course_project_microservice.repository.PersonRepository;
import com.bbuhha.course_project_microservice.repository.RoleRepository;
import com.bbuhha.course_project_microservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Optional<List<Person>> result = Optional.of(personRepository.findAll());

        if(result.isEmpty() || result.get().isEmpty()) {
            throw new NoSuchException("No any persons");
        }

        log.info("IN getAll - {} users found", result.get().size());
        return result.get();
    }

    @Override
    public Person findByUsername(String username)
    {
        Optional<Person> result = Optional.ofNullable(personRepository.findByUsername(username));

        if (result.isEmpty()) {
            throw new UsernameNotFoundException("User with username: " + username + " not found");
        }

        log.info("IN findByUsername - user: {} found by username: {}", result, username);
        return result.get();
    }

    @Override
    public Person findById(Long id)
    {
        Optional<Person> result = Optional.ofNullable(personRepository.findById(id).orElse(null));

        if (result.isEmpty()) {
            log.warn("IN findById - no user found by id: {}", id);
            throw new NoSuchException("Person with Id: " + id + " not found");
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result.get();
    }

    @Override
    public void deleteById(Long id)
    {
        Optional<Person> result = personRepository.findById(id);

        if(result.isEmpty()) {
            throw new NoSuchException("Person with Id: " + id + " not found");
        }

        personRepository.deleteById(id);
        log.info("IN delete - user with id: {} successfully deleted");
    }

}
