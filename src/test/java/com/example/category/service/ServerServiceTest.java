package com.example.category.service;

import com.example.category.entity.Server;
import com.example.category.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class ServerServiceTest {

    @Autowired
    private ServerService serverSerivce;

    @Test
    public void 서버넣기() {
        Server server = new Server();
        server.setMainUrl("uiyeon2");
        server.setTotalMem(200);
        server.setUsedMem(109);
        serverSerivce.saveServer(server);
    }

    @Test
    public void 서버하나id로찾기(){
        Server one = serverSerivce.findById(2);
        System.out.println(one);
    }

    @Test
    public void 서버하나url로찾기(){
        Server one = serverSerivce.findByMainUrl("uiyeon");
        System.out.println(one);
    }

    @Test
    public void 서버리스트다가져오기() {
        List<Server> serverList = serverSerivce.getServerList();

        System.out.println(serverList);
    }
    @Test
    public void 서버하나삭제() {
        serverSerivce.deleteOne(1);
    }
    @Test
    public void 서버모두삭제() { //db오류
        serverSerivce.deleteAll();
    }

    @Test
    public void 서버리스트메모리크기범위로가져오기() {
        List<Server> serverList = serverSerivce.findByTotalMemBetween(50L,200L);
        System.out.println(serverList);
    }

    @Test
    public void 서버리스트사용메모리범위로가져오기() {
        Iterable<Server> serverList = serverSerivce.findByUsedMemBetween(50L,200L);
        System.out.println(serverList);
    }
}
