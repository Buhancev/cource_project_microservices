package com.bbuhha.course_project_microservice.rest;


import com.bbuhha.course_project_microservice.dto.AuthenticationRequestDto;
import com.bbuhha.course_project_microservice.dto.PersonDto;
import com.bbuhha.course_project_microservice.dto.RegistrationRequestDto;
import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Role;
import com.bbuhha.course_project_microservice.security.Jwt.JwtTokenProvider;
import com.bbuhha.course_project_microservice.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/auth/")
@Slf4j

public class AuthenticationRestController
{

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final PersonService personService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager,
                                        JwtTokenProvider jwtTokenProvider, PersonService personService)
    {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.personService = personService;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto)
    {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            Person person = personService.findByUsername(username);

            if (person == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            List<Role> roles = person.getRoles();

            String token = jwtTokenProvider.createToken(username, roles);

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @PostMapping("/registration")
    public ResponseEntity registration(@RequestBody RegistrationRequestDto requestDto) {



        Person person = requestDto.toPerson();

        personService.registration(person);

        PersonDto userDto = PersonDto.fromPerson(person);
        return  ResponseEntity.ok(userDto);
    }
}