package com.bbuhha.course_project_microservice.security;


import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.security.Jwt.JwtPerson;
import com.bbuhha.course_project_microservice.security.Jwt.JwtUserFactory;
import com.bbuhha.course_project_microservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtPersonDetailsService implements UserDetailsService
{

    private final PersonService personService;

    @Autowired
    public JwtPersonDetailsService(PersonService personService)
    {
        this.personService = personService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException
    {
        Person user = personService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User with username: "
                    + username + " not found");
        }

        JwtPerson jwtUser = JwtUserFactory.create(user);
        log.info("IN loadUserByUsername - user with username: {} successfully loaded",
                username);
        return jwtUser;
    }
}
