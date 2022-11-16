package com.bbuhha.course_project_microservice.dto;

import com.bbuhha.course_project_microservice.model.Book;
import lombok.Data;

@Data
public class BookDao {
    public String name;
    public String description;

    public Book toBook() {
        Book book = new Book();
        book.setName(name);
        book.setDescription(description);

        return book;
    }

    public static BookDao fromBook(Book book) {
        BookDao bookDao = new BookDao();
        bookDao.setName(book.getName());
        bookDao.setDescription(book.getDescription());

        return bookDao;
    }
}
