package com.example.category.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@ToString
public class Service {

    @Id
    private String serviceId;

    private String serviceName;
}
