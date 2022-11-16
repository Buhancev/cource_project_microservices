package com.bbuhha.course_project_microservice.service;

import com.bbuhha.course_project_microservice.model.Book;

import java.util.List;

public interface BookService {
    public void add(Book book);

    public List<Book> findAll();

    public Book findByName(String name);

    public Book findById(Long id);

    public void deleteById(Long id);
}
