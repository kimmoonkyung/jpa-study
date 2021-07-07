package com.example.jpa.bookmanager.domain;

import com.example.jpa.bookmanager.domain.listener.Auditable;
import com.example.jpa.bookmanager.domain.listener.MyEntityListener;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
//@EntityListeners(value = MyEntityListener.class)
public class Book extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;
    private String author;

//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist() {
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        this.updatedAt = LocalDateTime.now();
//    }


}
