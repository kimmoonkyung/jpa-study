package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    void bookTest() {
        Book book = Book.builder()
                .name("JPA 공부")
                .authorId(1L)
                .publisherId(1L)
                .build();

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

}