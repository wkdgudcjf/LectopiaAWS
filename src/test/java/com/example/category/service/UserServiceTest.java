package com.example.category.service;

import com.example.category.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by ksb on 2017. 9. 23..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void 유저넣기() {
        User user = new User();
        user.setEmail("bming0227@mail.com");
        user.setPassword("pwd");
        userService.saveUser(user);
    }

    @Test
    public void 유저리스트가져오기() {
        Iterable<User> userList = userService.getUserList();

        System.out.println(userList);
    }

    @Test
    public void 유저로그인() {
        User user = userService.login("bming0227@mail.com","pwd");
        System.out.println(user);
    }

    @Test
    public void 유저로그인실패() {
        User user = userService.login("실패","실패");
        System.out.println(user);
    }

    @Test
    public void 유저리스트id가져오기() {
        List<User> user = userService.getUserList(1);
        System.out.println(user);
    }


    @Test
    public void 유저리스트id가져오기실패() {
        List<User> user = userService.getUserList(5000);
        System.out.println(user);
    }

    @Test
    public void 유저저장하기() {
        this.userService.saveUser("testemail2", "pwd2", false);
    }

    @Test
    public void 서버업데이트() {
        this.userService.updateUserServer(1,2);
    }
}
