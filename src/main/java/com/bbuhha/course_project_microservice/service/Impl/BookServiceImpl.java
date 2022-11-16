package com.bbuhha.course_project_microservice.service.Impl;

import com.bbuhha.course_project_microservice.model.Book;
import com.bbuhha.course_project_microservice.repository.BookRepository;
import com.bbuhha.course_project_microservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void add(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = bookRepository.findAll();
        return result;
    }

    @Override
    public Book findByName(String name) {
        Book result = bookRepository.findByName(name);
        return result;
    }

    @Override
    public Book findById(Long id) {
        Optional<Book> result = bookRepository.findById(id);
        return result.get();
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
