package com.example.category.service;

import com.example.category.entity.Region;
import com.example.category.entity.Server;
import com.example.category.repository.RegionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class ServerServiceTest {

    @Autowired
    private ServerService serverSerivce;

    @Autowired
    private RegionRepository regionRepository;

    @Test
    public void 서버넣기() {
        Server server = new Server();
        server.setMainUrl("reTest4");
        server.setTotalMem(111);
        server.setUsedMem(109);
        ArrayList<Region> region = new ArrayList<Region>();
        Region r1 = new Region();
        r1.setId(1);
        r1.setName("한국");
        Region r2 = new Region();
        r2.setId(2);
        r2.setName("미국");

        region.add(r1);
        region.add(r2);

        server.setRegionList(region);
        serverSerivce.saveServer(server);
    }

    @Test
    @Transactional
    public void 서버하나id로찾기(){
        Server one = serverSerivce.findById(7);
        System.out.println(one);
    }

    @Test
    public void 서버하나url로찾기(){
        Server one = serverSerivce.findByMainUrl("uiyeon");
        System.out.println(one);
//        System.out.println(one.getRegionList());
    }

    @Test
    @Transactional
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
