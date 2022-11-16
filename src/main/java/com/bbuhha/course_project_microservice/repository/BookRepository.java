package com.bbuhha.course_project_microservice.repository;

import com.bbuhha.course_project_microservice.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    public Book findByName(String name);
}
