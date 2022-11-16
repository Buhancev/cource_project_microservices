package com.bbuhha.course_project_microservice.security;

import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.security.jwt.JwtPerson;
import com.bbuhha.course_project_microservice.security.jwt.JwtPersonFactory;
import com.bbuhha.course_project_microservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtPersonDetailsService implements UserDetailsService {

    private final PersonService personService;

    @Autowired
    public JwtPersonDetailsService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Person> result = Optional.ofNullable(personService.findByUsername(username));

        if(result.isPresent()) {
            JwtPerson jwtPerson = JwtPersonFactory.create(result.get());

            return jwtPerson;
        }
        else {
            throw new UsernameNotFoundException("Person with username: "
                    + username + " not found");
        }
    }
}
