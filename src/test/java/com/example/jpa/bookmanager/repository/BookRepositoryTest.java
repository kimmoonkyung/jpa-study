package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.Book;
import com.example.jpa.bookmanager.domain.Publisher;
import com.example.jpa.bookmanager.domain.Review;
import com.example.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    void bookTest() {
        Book book = new Book();
        book.setName("JPA 공부");
        book.setAuthorId(1L);

        bookRepository.save(book);

        System.out.println(bookRepository.findAll());
    }

    @Test
    @Transactional
    void bookRelationTest() {
        givenBookAndReview();

        User user = userRepository.findByEmail("norotoo@pornhub.com");

        System.out.println("## Review: " + user.getReviews());
        System.out.println("## Book: " + user.getReviews().get(0).getBook());
        System.out.println("## Publisher: " + user.getReviews().get(0).getBook().getPublisher());
    }

    private void givenBookAndReview() {
        givenReview(givenUser(), givenBook(givenPublisher()));
    }

    private Book givenBook(Publisher publisher) {
        Book book = new Book();
        book.setName("짐승균의 노충내 정복기");
        book.setPublisher(publisher);

        return bookRepository.save(book);
    }

    private User givenUser() {
        return userRepository.findByEmail("norotoo@pornhub.com");
    }

    private void givenReview(User user, Book book) {
        Review review = new Review();
        review.setTitle("설득의 심리학");
        review.setContent("리부에요 와하하!!");
        review.setScore(5.0f);
        review.setUser(user);
        review.setBook(book);

        reviewRepository.save(review);
    }

    private Publisher givenPublisher() {
        Publisher publisher = new Publisher();
        publisher.setName("마계 짐승");

        return publisherRepository.save(publisher);
    }
}