package com.bbuhha.course_project_microservice.security.Jwt;


import com.bbuhha.course_project_microservice.model.Person;
import com.bbuhha.course_project_microservice.model.Role;
import com.bbuhha.course_project_microservice.model.Status;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory
{

    public JwtUserFactory()
    {}

    public static JwtPerson create(Person user)
    {
        return new JwtPerson(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAuthorities(new ArrayList<>(user.getRoles())),
                user.getStatus().equals(Status.ACTIVE),
                user.getUpdated()
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