package com.example.category.repository;

import java.util.List;

import com.example.category.entity.User;
import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findById(String id);
    List<User> findByEmail(String email);
}