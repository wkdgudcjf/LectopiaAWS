package com.example.category.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Arrays;
import java.util.List;

/**
 * Created by whilemouse on 17. 8. 31.
 */
@Entity
@DiscriminatorValue("COMPOSITE")
@Data
@EqualsAndHashCode(callSuper=false)
@ToString(exclude = "children")
public class CategoryComposite extends CategoryComponent {

    @OneToMany(mappedBy = "parent")
    private List<CategoryComponent> children = Arrays.asList();
}
