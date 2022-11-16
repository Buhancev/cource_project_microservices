package com.bbuhha.course_project_microservice.service.imlp;

import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.repository.PersonRepository;
import com.bbuhha.course_project_microservice.repository.RoleRepository;
import com.bbuhha.course_project_microservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;
    private final RoleRepository repository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, RoleRepository repository, BCryptPasswordEncoder passwordEncoder) {

        this.personRepository = personRepository;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Person registration(Person person) {

        return null;
    }

    @Override
    public List<Person> findAll() {

        List<Person> result = personRepository.findAll();
        return result;
    }

    @Override
    public Person findById(Long id) {

        Optional<Person> result = personRepository.findById(id);

        if(result.isPresent()) {
            return result.get();
        }
        else {
            return null;
        }
    }

    @Override
    public Person findByUsername(String username) {

        Optional<Person> result = Optional.ofNullable(personRepository.findByUsername(username));

        if(result.isPresent()) {
            return result.get();
        }
        else {
            return null;
        }
    }

    @Override
    public void deleteById(Long id) {

        personRepository.deleteById(id);
    }
}
