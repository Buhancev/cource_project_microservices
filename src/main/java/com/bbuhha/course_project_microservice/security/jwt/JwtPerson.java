package com.bbuhha.course_project_microservice.security.jwt;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

//С точки зрения JWT, он работает не с нашим Person, а со своим
public class JwtPerson implements UserDetails {

    private final Long id;
    private final String username;
    private final String password;
    private final boolean enabled;
    private final Date lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;

    public JwtPerson(Long id,
                     String username,
                     String password,
                     boolean enabled,
                     Date lastPasswordResetDate,
                     Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
    }



    @JsonIgnore
    public Long getId()
    {
        return id;
    }

    @Override
    public String getUsername()
    {
        return username;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate()
    {
        return lastPasswordResetDate;
    }
}
