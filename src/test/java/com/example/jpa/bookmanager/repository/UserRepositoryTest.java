package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.contains;
import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.endsWith;

@SpringBootTest // Spring 컨텍스트 로딩해서 테스트에 활용 하겠다는 어노테이션
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void crud() {
//        userRepository.save(new User());
//        userRepository.findAll().forEach(System.out::println);

        // findAll(Sort.)
//        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));

        // findAllById(Lists.)
//          id ==> 1, 3, 5의 리스트를 뽑아온다.
//        List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));
//        users.forEach(System.out::println);

        // saveAll
//        User user1 = User.builder()
//                .name("짐승균")
//                .email("짐승균@이메일.com")
//                .build();
//        User user2 = User.builder()
//                .name("짐승내")
//                .email("짐승내@이메일.com")
//                .build();
//
//        userRepository.saveAll(Lists.newArrayList(user1, user2));
//
//        List<User> users = userRepository.findAll();
//        users.forEach(System.out::println);

        // optional
//        User user = userRepository.findById(1L).orElse(null);
//        System.out.println(user);

        // flush
//        userRepository.saveAndFlush(User.builder().name("노충내").email("노충내@이메일.com").build());
//        // userRepository.flush();
//        userRepository.findAll().forEach(System.out::println);

        // existsById
//        boolean exists = userRepository.existsById(6L);
//        System.out.println(exists);

        // delete
//        userRepository.delete(userRepository.findById(1L).orElseThrow(RuntimeException::new));
//        userRepository.deleteAll(userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)));
//        userRepository.deleteInBatch(userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L)));
//        userRepository.deleteAllInBatch();
//        userRepository.findAll().forEach(System.out::println);
//        userRepository.findAll().forEach(user -> System.out.println(user.getId()));

        // page
//        Page<User> users = userRepository.findAll(PageRequest.of(1, 3));
//        System.out.println(">>> page: " + users);
//        System.out.println(">>> total Elements: " + users.getTotalElements());
//        System.out.println(">>> total Pages: " + users.getTotalPages());
//        System.out.println(">>> number Of Elements: " + users.getNumberOfElements());
//        System.out.println(">>> sort: " + users.getSort());
//        System.out.println(">>> size: " + users.getSize());
//
//        users.getContent().forEach(System.out::println);

        // Like ExampleMatcher (contains)
        User user = User.builder().name("beast").build();
        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", contains());
        Example<User> example = Example.of(user, matcher);

        userRepository.findAll(example).forEach(System.out::println);

    }

}