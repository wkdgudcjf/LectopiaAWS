package com.example.category.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String mainUrl;

    private long totalMem;

    private long usedMem;

    private int state;

    @OneToMany(mappedBy = "server")
    private List<Region> regionList;

    @OneToMany(mappedBy = "server")
    private List<Service> serviceList;

    @OneToMany(mappedBy = "server")
    private List<Url> urlList;

    @OneToMany(mappedBy = "server")
    private List<User> userList;

}