package com.example.category.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString(exclude = {"server","region"})
public class Traffic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    private int mem;

}