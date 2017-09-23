package com.example.category.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString(exclude = "serverRegionList")
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String name;

    @OneToMany(mappedBy = "region")
    private List<ServerRegion> serverRegionList;
}
