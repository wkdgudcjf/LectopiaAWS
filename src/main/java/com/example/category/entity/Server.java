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
import java.util.List;

@Entity
@Data
@Getter @Setter
@ToString
public class Server {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int serverId;

    @Column
    private String mainUrl;

    @Column
    private long TotalMem;

    @Column
    private long usedMem;

    @Column
    private int state;

//    private List regionList<Region>;
//    private List serviceList<Service>;
//    private List urlList<Url>;
}
