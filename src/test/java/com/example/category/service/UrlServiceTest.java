package com.example.category.service;

import com.example.category.entity.Server;
import com.example.category.entity.Url;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Iterator;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("mysql")
public class UrlServiceTest {
    @Autowired
    private UrlService urlService;

    @Test
    public void url넣기(){
        Url url = new Url();
        url.setName("korea");
        Server server = new Server();
        server.setId(2);
        server.setMainUrl("uiveon");
        server.setState(0);
        server.setTotalMem(100);
        server.setUsedMem(99);


        url.setServer(server);

        urlService.saveUrl(url);
    }
    @Test
    public void url_id로찾기(){
        Url url = urlService.getUrl(1);
        System.out.println(url.getName());

    }

    @Test
    public void 모든url가져오기(){
        Iterable<Url> list = urlService.getAll();
        System.out.println(list);
    }
}
