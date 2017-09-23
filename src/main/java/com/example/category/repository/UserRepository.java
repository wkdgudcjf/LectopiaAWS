package com.example.category.repository;

import com.example.category.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmail(String email);
    List<User> findByEmailAndPassword(String email, String password);


}