package com.example.category.repository.custom.impl;

import com.example.category.entity.Category;
import com.example.category.repository.custom.CustomCategoryRepository;
import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import static com.example.category.entity.QCategory.category;


/**
 * Created by whilemouse on 17. 8. 31.
 */
public class CategoryRepositoryImpl extends QueryDslRepositorySupport implements CustomCategoryRepository {

    public CategoryRepositoryImpl() {
        super(Category.class);
    }

    @Override
    public Category find() {
        return null;
    }

    @Override
    public Category find(String name) {
        JPQLQuery query = from(category)
                .join(category.children).fetchJoin()
                .where(category.name.eq(name));
        return (Category) query.fetchOne();
    }
}
