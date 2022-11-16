package com.bbuhha.course_project_microservice.repository;

import com.bbuhha.course_project_microservice.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long>
{
    public Role findByName(String name);
}
