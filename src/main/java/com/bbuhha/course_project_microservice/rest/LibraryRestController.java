package com.bbuhha.course_project_microservice.rest;

import com.bbuhha.course_project_microservice.dto.BookDao;
import com.bbuhha.course_project_microservice.model.Book;
import com.bbuhha.course_project_microservice.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
@Slf4j
public class LibraryRestController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/")
    public List<Book> showAllBooks() {
        List<Book> result = bookRepository.findAll();

        return result;
    }

    @GetMapping("/{id}")
    public BookDao showBookById(@PathVariable Long id) {
        Optional<Book> result = bookRepository.findById(id);


        log.info("Book finded:" + result.get().getName());

        BookDao bookDao = BookDao.fromBook(result.get());

        return bookDao;
    }

}
