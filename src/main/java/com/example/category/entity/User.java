package com.example.category.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String password;

    @Column(unique = true)
    private String email;

    @OneToOne
    @JoinColumn(name = "server_id")
    private Server server;

    private boolean isAdmin;
}
