package com.bbuhha.course_project_microservice.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "vault")
@Data
public class Note extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
