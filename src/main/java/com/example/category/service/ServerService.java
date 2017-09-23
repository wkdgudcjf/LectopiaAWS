package com.example.category.service;

import com.example.category.entity.Server;
import com.example.category.repository.ServerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServerService {

    @Autowired
    private ServerRepository serverRepository;

    //--------- 추가 methods
//    public Iterable<Server> findByTotalMemLessThanEqual(long totalMem){
//        return serverRepository.findByTotalMemLessThanEqual(totalMem);
//    }
//    public Iterable<Server> findByTotalMemGreaterThanEqual(long totalMem){
//        return serverRepository.findByTotalMemGreaterThanEqual(totalMem);
//    }
//
    public List<Server> findByTotalMemBetween(long min, long max){
        return serverRepository.findByTotalMemBetween(min,max);
    }

    public List<Server> findByUsedMemBetween(long min, long max){
        return serverRepository.findByUsedMemBetween(min, max);
    }
//    public List<Server> findByUsedMemLessThanEqual(long usedMem){
//        return serverRepository.findByUsedMemLessThanEqual(usedMem);
//    }
//    public List<Server> findByUsedMemGreaterThanEqual(long usedMem){
//        return serverRepository.findByUsedMemGreaterThanEqual(usedMem);
//    }
    public List<Server> findByState(int state){
        return serverRepository.findByState(state);
    }
    public Server findByMainUrl(String mainUrl){
        return serverRepository.findByMainUrl(mainUrl);
    }
    //------

    //------ 원래 repe의 methods
    public Iterable<Server> getServerList() {
        return serverRepository.findAll();
    }
    public Server findById(long id){ return serverRepository.findOne(id); }
    public void deleteOne(long id){ serverRepository.delete(id); }
    public void deleteAll(){ serverRepository.deleteAll(); }
    public void saveServer(Server server) {
        serverRepository.save(server);
    }
}
