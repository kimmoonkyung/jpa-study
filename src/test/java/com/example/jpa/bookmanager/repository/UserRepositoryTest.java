package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;

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
//        User user = User.builder().name("beast").build();
//        ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("name", contains());
//        Example<User> example = Example.of(user, matcher);
//
//        userRepository.findAll(example).forEach(System.out::println);

        // update
        userRepository.save(User.builder().name("충내르").email("충내@이메일.com").build());

        User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
        user.setEmail("noroguy@pornhub.com");

        userRepository.save(user);

    }

    @Test
    void select() {
//        System.out.println(userRepository.findByName("mxxnkyung"));
//
//        System.out.println(">>> findByEmail : " + userRepository.findByEmail("mxxnkyung@gmail.com"));
//        System.out.println(">>> getByEmail : " + userRepository.getByEmail("mxxnkyung@gmail.com"));
//        System.out.println(">>> readByEmail : " + userRepository.readByEmail("mxxnkyung@gmail.com"));
//        System.out.println(">>> queryByEmail : " + userRepository.queryByEmail("mxxnkyung@gmail.com"));
//        System.out.println(">>> searchByEmail : " + userRepository.searchByEmail("mxxnkyung@gmail.com"));
//        System.out.println(">>> streamByEmail : " + userRepository.streamByEmail("mxxnkyung@gmail.com"));
//        System.out.println(">>> findUserByEmail : " + userRepository.findUserByEmail("mxxnkyung@gmail.com"));
//
//        System.out.println(">>> findSomethingByEmail : " + userRepository.findSomethingByEmail("mxxnkyung@gmail.com"));
//
//        System.out.println(">>> findFirst1ByName : " + userRepository.findFirst1ByName("mxxnkyung"));
//        System.out.println(">>> findTop1ByName : " + userRepository.findTop1ByName("mxxnkyung"));

//        System.out.println(">>> findLast1ByName : " + userRepository.findLast1ByName("mxxnkyung"));

//        System.out.println(">>> findByEmailAndName : " + userRepository.findByEmailAndName("mxxnkyung@gmail.com","mxxnkyung"));
//        System.out.println(">>> findByEmailOrName : " + userRepository.findByEmailOrName("mxxnkyung@gmail.com","mxxnkyung"));

//        System.out.println(">>> findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println(">>> findByIdAfter : " + userRepository.findByIdAfter(4L));

//        System.out.println(">>> findByCreatedAtGreaterThanAnd : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
//        System.out.println(">>> findByCreatedAtGreaterThanAnd : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));

//        System.out.println(">>> findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
//        System.out.println(">>> findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

//        System.out.println(">>> findByIdGreaterThanEqualAndIdLessThanEqual : " + userRepository.findByIdGreaterThanEqualAndIdLessThanEqual(1L, 3L));

//        System.out.println(">>> findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//        System.out.println(">>> findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());
//        System.out.println(">>> findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("mxxnkyung", "norotoo")));

//        System.out.println(">>> findByStartingWith : " + userRepository.findByNameStartingWith("beast"));
//        System.out.println(">>> findByEndingWith : " + userRepository.findByNameEndingWith("yun"));
//        System.out.println(">>> findByContains : " + userRepository.findByNameContains("xx"));
//
//        System.out.println(">>> findByNameLike : " + userRepository.findByNameLike("%xx%"));

    }

    @Test
    void pagingAndSortingTest() {
//        System.out.println(">>> findTop1ByName : " + userRepository.findTop1ByName("mxxnkyung"));
//        System.out.println(">>> findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("mxxnkyung"));
//        System.out.println(">>> findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("mxxnkyung"));

//        System.out.println(">>> findFirstByNameWithSortParams : " + userRepository.findFirstByName("mxxnkyung", Sort.by(Sort.Order.desc("id"))));
//        System.out.println(">>> findFirstByNameWithSortParams : " + userRepository.findFirstByName("mxxnkyung", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));

        System.out.println(">>> findByNameWithPaging page 1p : " + userRepository.findByName("mxxnkyung", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
        System.out.println(">>> findByNameWithPaging page 2p : " + userRepository.findByName("mxxnkyung", PageRequest.of(1, 1, Sort.by(Sort.Order.desc("id")))).getContent());

    }

}