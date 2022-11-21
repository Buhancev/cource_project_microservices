package com.bbuhha.course_project_microservice.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "vault")
@Data
public class Note extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinTable(name = "person_notes",
            joinColumns = {@JoinColumn(name = "note_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "person_id", referencedColumnName = "id")})
    private Person owner;


    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
