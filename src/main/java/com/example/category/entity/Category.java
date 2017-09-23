package com.example.category.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
@ToString(exclude = "parent")
public class Category {

    @Id
    @GeneratedValue(generator="UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    private String name;

    @ManyToOne
    @JoinColumn(name="parent_id")
    private Category parent;

    @Fetch(FetchMode.SUBSELECT)
    @OneToMany(mappedBy = "parent")
    private List<Category> children = Arrays.asList();
}
