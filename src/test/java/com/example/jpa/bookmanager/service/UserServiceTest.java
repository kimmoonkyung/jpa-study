package com.example.jpa.bookmanager.service;

import com.example.jpa.bookmanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {
        userService.put4();

        System.out.println(">>> 비영속 상태: " + userRepository.findByEmail("귀염둥이충내@커염둥이충내.com"));
    }

    @Test
    void test2() {
        userService.put4();

        userRepository.findAll().forEach(System.out::println);
    }

}