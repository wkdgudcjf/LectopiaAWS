package com.example.category.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;
}
