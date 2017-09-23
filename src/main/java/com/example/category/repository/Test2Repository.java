package com.example.category.repository;

import com.example.category.entity.Test2;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by ksb on 2017. 9. 23..
 */
public interface Test2Repository extends JpaRepository<Test2, UUID> {
}
