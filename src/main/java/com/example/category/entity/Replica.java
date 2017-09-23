package com.example.category.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Replica {

    @Id
    @GeneratedValue
    private int id;

    /**
     * 0xff (북아메리카,남아메리카,서유럽,동유럽,아프리카,서아시아,중앙아시아,동아시아)
     */
    private int serverLocation;

}
