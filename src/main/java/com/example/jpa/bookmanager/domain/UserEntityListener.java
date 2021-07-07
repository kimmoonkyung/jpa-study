package com.example.jpa.bookmanager.domain;

import com.example.jpa.bookmanager.repository.UserHistoryRepository;
import com.example.jpa.bookmanager.support.BeanUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

public class UserEntityListener {

//    EntityListener 는 spring bean을 주입 받지 못한다.
//    @Autowired
//    private UserHistoryRepository userHistoryRepository;

    @PrePersist
    @PreUpdate
    public void prePersistAndPreUpdate(Object o) {

        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);

        User user = (User) o;
        UserHistory userHistory = UserHistory.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();

        userHistoryRepository.save(userHistory);

    }

}
