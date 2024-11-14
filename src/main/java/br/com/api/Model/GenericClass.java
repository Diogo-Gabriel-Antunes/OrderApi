package br.com.api.Model;

import jakarta.persistence.*;

import java.time.LocalDateTime;



@MappedSuperclass
public abstract class GenericClass {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String uuid;
    private String userUuid;
    private LocalDateTime updatedTime;
    private LocalDateTime createdTime;

    @PrePersist
    public void prePersist(){
        updatedTime = LocalDateTime.now();
        createdTime = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        updatedTime = LocalDateTime.now();
    }

    public String getUuid() {
        return uuid;
    }


}
