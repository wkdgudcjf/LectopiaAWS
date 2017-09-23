package com.example.category.service;

import com.example.category.entity.Server;
import com.example.category.entity.User;
import com.example.category.repository.ServerRepository;
import com.example.category.repository.UserRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ksb on 2017. 9. 23..
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ServerRepository serverRepository;

    public List<User> getUserList() {
        Iterable<User> iteUser = userRepository.findAll();
        List<User> user= Lists.newArrayList(iteUser);
        return user;
    }
    public List<User> getUserList(long id) {
        User user = userRepository.findOne(id) ;
        List<User> list = new ArrayList<User>();
        list.add(user);
        return list;
    }

    public User login(String email, String password) {
        List<User> userList = userRepository.findByEmailAndPassword(email,password);
        if(userList == null || userList.isEmpty() == true) {
            return null;
        }

        return userList.get(0);
    }

    public void saveUser(String email, String password, boolean isAdmin) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAdmin(isAdmin);
        userRepository.save(user);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUserServer(long userId, long serverId) {
        Server server = serverRepository.findOne(serverId);
        User user = userRepository.findOne(userId);
        server.setUser(user);
        user.setServer(server);
    }



}
