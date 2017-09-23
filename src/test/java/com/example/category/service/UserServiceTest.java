package com.example.category.service;

import com.example.category.entity.User;
import com.example.category.repository.Test2Repository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ksb on 2017. 9. 23..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class UserServiceTest {

    @Autowired
    private UserSerivce userSerivce;

    @Test
    public void 유저넣기() {
        User user = new User();
        user.setEmail("ksb@mail.com");
        userSerivce.saveUser(user);
    }

    @Test
    public void 유저리스트가져오기() {
        Iterable<User> userList = userSerivce.getUserList();

        System.out.println(userList);
    }

}
