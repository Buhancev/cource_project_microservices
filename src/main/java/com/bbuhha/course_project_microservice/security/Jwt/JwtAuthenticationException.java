package com.bbuhha.course_project_microservice.security.Jwt;

import org.springframework.security.core.AuthenticationException;

public class JwtAuthenticationException extends AuthenticationException
{
    public JwtAuthenticationException(String msg, Throwable t)
    {
        super(msg, t);
    }

    public JwtAuthenticationException(String msg)
    {
        super(msg);
    }
}
