package com.example.category.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@ToString(exclude = {"regionList", "userList", "serviceList", "urlList"})
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(unique = true)
    private String mainUrl;

    private long totalMem;

    private long usedMem;

    private int state;

    @OneToMany(mappedBy = "server")
    private List<ServerRegion> serverRegionList;

    @OneToMany(mappedBy = "server")
    private List<Service> serviceList;

    @OneToMany(mappedBy = "server")
    private List<Url> urlList;

    @OneToOne(mappedBy = "server")
    private User user;

}