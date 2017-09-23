package com.example.category.service;

import com.example.category.entity.Region;
import com.example.category.entity.Server;
import com.example.category.entity.Traffic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Temporal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class TrafficServiceTest {
    @Autowired
    TrafficService trafficService;

    @Test
    public void 트래픽저장(){
        Traffic traffic = new Traffic();

        Region region = new Region();
        region.setId(1);
        region.setName("korea");

        Server server = new Server();
        server.setId(2);
        server.setMainUrl("uiveon");
        server.setState(0);
        server.setTotalMem(100);
        server.setUsedMem(99);

        region.setServer(server);

        traffic.setRegion(region);
        traffic.setServer(server);
        traffic.setMem(12);

        trafficService.saveTraffic(traffic);
    }

    @Test
    public void 모든프래픽_가져오기(){
        Iterable<Traffic> list = trafficService.getTrafficList();
        System.out.println(list);
    }
    @Test
    public void serverid의_트래픽_가져오기(){
        List<Traffic> list = trafficService.getTrafficList(2);
        System.out.println(list.get(0).getId());
    }
}
