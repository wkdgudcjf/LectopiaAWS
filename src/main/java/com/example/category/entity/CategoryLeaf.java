package com.example.category.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by whilemouse on 17. 8. 31.
 */
@Entity
@DiscriminatorValue("LEFT")
@Data
@EqualsAndHashCode(callSuper=false)
public class CategoryLeaf extends CategoryComponent {
}
