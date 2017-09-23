package com.example.category.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@ToString
public class User {
    @Id
    private String userId;

    @Column
    private String password;

    @Column
    private String email;

    private Server server;

    private boolean isAdmin;

    public User(){};

    public User(String userId, String password, String email, Server server, boolean isAdmin) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.server = server;
        this.isAdmin = isAdmin;
    }
}
