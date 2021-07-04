package com.example.jpa.bookmanager.domain;

import javax.persistence.PrePersist;
import java.time.LocalDateTime;

public class MyEntityListener {

    @PrePersist
    public void prePersist(Object obj) {
        if(obj instanceof Auditable) {
            ((Auditable) obj).setCreatedAt(LocalDateTime.now());
            ((Auditable) obj).setUpdatedAt(LocalDateTime.now());

        }
    }

}
