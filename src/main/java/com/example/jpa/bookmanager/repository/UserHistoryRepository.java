package com.example.jpa.bookmanager.repository;

import com.example.jpa.bookmanager.domain.UserHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long> {
}
