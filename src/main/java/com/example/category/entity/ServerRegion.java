package com.example.category.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

/**
 * Created by ksb on 2017. 9. 24..
 */
@Data
@Entity
@ToString(exclude = "server")
public class ServerRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "server_id")
    private Server server;

}
