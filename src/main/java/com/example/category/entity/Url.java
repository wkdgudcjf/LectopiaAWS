package com.example.category.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString(exclude = {"server"})
public class Url {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;
}
