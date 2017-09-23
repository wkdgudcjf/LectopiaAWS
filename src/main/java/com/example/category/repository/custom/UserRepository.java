package com.example.category.repository.custom;

import java.util.List;

import com.example.category.entity.User;
import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, String> {

    List<User> findByUserId(String userId);
    List<User> findByEmail(String email);
}