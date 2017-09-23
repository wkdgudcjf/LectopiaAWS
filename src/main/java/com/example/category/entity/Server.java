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
    private int userId;

    @Column
    private String urlMappings;

    @Column
    private long usedMem;

    @Column
    private String file;

    @Column
    private int fileSystem;
    //0 텍스트 1이미지 등
    @Column
    private int state;
    //0 중지 1실행중 2아시아서버?? 등등..?
}
