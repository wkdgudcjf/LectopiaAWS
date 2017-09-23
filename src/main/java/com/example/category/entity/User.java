package com.example.category.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Email;

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
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

    private boolean isAdmin;
}
