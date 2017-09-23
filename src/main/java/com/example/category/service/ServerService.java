package com.example.category.service;

import com.example.category.entity.Server;
import com.example.category.repository.RegionRepository;
import com.example.category.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    @Autowired
    private RegionRepository regionRepository;

    //--------- 추가 methods
    /*public Iterable<Server> findByTotalMemLessThanEqual(long totalMem){
        return serverRepository.findByTotalMemLessThanEqual(totalMem);
    }
    public Iterable<Server> findByTotalMemGreaterThanEqual(long totalMem){
        return serverRepository.findByTotalMemGreaterThanEqual(totalMem);
    }*/

    public List<Server> findByTotalMemBetween(long min,long max){
        return serverRepository.findByTotalMemBetween(min, max);
    }

    public List<Server> findByUsedMemBetween(long min,long max){
        return serverRepository.findByUsedMemBetween( min, max);
    }
   /* public List<Server> findByUsedMemLessThanEqual(long usedMem){
        return serverRepository.findByUsedMemLessThanEqual(usedMem);
    }
    public List<Server> findByUsedMemGreaterThanEqual(long usedMem){
        return serverRepository.findByUsedMemGreaterThanEqual(usedMem);
    }*/
    public List<Server> findByState(int state){
        return serverRepository.findByState(state);
    }
    public Server findByMainUrl(String mainUrl){
        return serverRepository.findByMainUrl(mainUrl);
    }


    //------

    //------ 원래 repe의 methods
    public List<Server> getServerList() {
        return (List<Server>)serverRepository.findAll();
    }
    public Server findById(long id){ return serverRepository.findOne(id); }
    public void deleteOne(long id){ serverRepository.delete(id); }
    public void deleteAll(){ serverRepository.deleteAll(); }

    @Transactional
    public long  saveServer(Server server) {
        server.setState(1);
        serverRepository.save(server);
        return server.getId();
    }

    @Transactional
    public void updateUsedMem(long serverId, long addMem) {
        Server server = serverRepository.findOne(serverId);
        long sum = server.getUsedMem() + addMem;
        server.setUsedMem(sum);
    }

}
