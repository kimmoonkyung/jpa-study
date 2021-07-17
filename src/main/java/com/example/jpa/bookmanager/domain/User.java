package com.example.jpa.bookmanager.domain;


import com.example.jpa.bookmanager.domain.listener.Auditable;
import com.example.jpa.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@EntityListeners(value = { /*AuditingEntityListener.class,*/ UserEntityListener.class })
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    private String email;

    @Transient
    private String testData;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @PrePersist
//    public void prePersist() {
//        System.out.println(">>> prePersist ! ");
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate() {
//        System.out.println(">>> preUpdate ! ");
//        this.updatedAt = LocalDateTime.now();
//    }

    @OneToMany(fetch = FetchType.EAGER)
    private List<Address> address;

}
