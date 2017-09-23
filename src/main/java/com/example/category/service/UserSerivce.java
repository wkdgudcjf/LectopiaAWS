package com.example.category.service;

import com.example.category.entity.User;
import com.example.category.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ksb on 2017. 9. 23..
 */
@Service
public class UserSerivce {

    @Autowired
    private UserRepository userRepository;

    public Iterable<User> getUserList() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}
