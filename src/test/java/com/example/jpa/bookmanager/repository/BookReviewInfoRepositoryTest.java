package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import com.example.jpa.bookmanager.domain.BookReviewInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookReviewInfoRepositoryTest {

    @Autowired
    private BookReviewInfoRepository bookReviewInfoRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    void crudTest(){
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(givenBook())
                .averageReviewScore(4.5f)
                .reviewCount(2)
                .build();

        bookReviewInfoRepository.save(bookReviewInfo);

        System.out.println(">>> : " + bookReviewInfoRepository.findAll());
    }

    @Test
    void crudTest2() {

        givenBookReviewInfo();

        Book result = bookReviewInfoRepository
                .findById(1L)
                .orElseThrow(RuntimeException::new)
                .getBook();

        System.out.println(">>> result : " + result);

        BookReviewInfo result2 = bookRepository.findById(1L).orElseThrow(RuntimeException::new).getBookReviewInfo();

        System.out.println(">>> result2 : " + result2);

    }

    private Book givenBook() {
        Book book = Book.builder()
                .name("JPA 공부 책")
                .authorId(1L)
//                .publisherId(1L)
                .build();

//        System.out.println(">>> book : " + bookRepository.findAll());
        return bookRepository.save(book);
    }

    private void givenBookReviewInfo() {
        BookReviewInfo bookReviewInfo = BookReviewInfo.builder()
                .book(givenBook())
                .averageReviewScore(4.5f)
                .reviewCount(2)
                .build();

        bookReviewInfoRepository.save(bookReviewInfo);
        System.out.println(">>> bookReviewInfo : " + bookReviewInfoRepository.findAll());
    }

}