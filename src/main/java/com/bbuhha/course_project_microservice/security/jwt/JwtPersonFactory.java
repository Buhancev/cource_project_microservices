package com.bbuhha.course_project_microservice.security.jwt;

import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Role;
import com.bbuhha.course_project_microservice.model.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtPersonFactory {

    public JwtPersonFactory() {
    }

    public static JwtPerson create(Person person)
    {
        return new JwtPerson(
                person.getId(),
                person.getUsername(),
                person.getPassword(),
                person.getStatus().equals(Status.ACTIVE),
                person.getUpdated(),
                mapToGrantedAuthorities(new ArrayList<>(person.getRoles()))
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles)
    {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}
