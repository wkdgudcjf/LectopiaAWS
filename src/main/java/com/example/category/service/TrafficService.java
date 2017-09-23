package com.example.category.service;

import com.example.category.entity.Server;
import com.example.category.entity.Traffic;
import com.example.category.repository.TrafficRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


@Service
public class TrafficService {
    @Autowired
    TrafficRepository trafficRepository;

    public void saveTraffic(Traffic traffic){
        Date date = new Date();
        traffic.setDate(date);
        trafficRepository.save(traffic);
    }
    public Iterable<Traffic> getTrafficList(Date d1, Date d2, long serverId){
        List<Traffic> all = getTrafficList(serverId);
        ArrayList<Traffic> traffic = new ArrayList<Traffic>();
        for(int i = 0; i < all.size(); ++i){
            Traffic t = all.get(i);
            if(t.getDate().after(d1) || t.getDate().before(d2)){
                traffic.add(t);
            }
        }
        return traffic;
    }
    public List<Traffic> getTrafficList(Date d1, Date d2){
        List<Traffic> all = getTrafficList();
        ArrayList<Traffic> traffic = new ArrayList<Traffic>();
        for(int i = 0; i < all.size(); ++i){
            Traffic t = all.get(i);
            if(t.getDate().after(d1) || t.getDate().before(d2)){
                traffic.add(t);
            }
        }
        return traffic;
    }
    public List<Traffic> getTrafficList(long serverId){
        List<Traffic> all = getTrafficList();
        ArrayList<Traffic> traffic = new ArrayList<>();
        for(int i = 0; i < all.size(); ++i){
            Traffic t = all.get(i);
            if(t.getServer().getId() == serverId)
                traffic.add(t);
        }
        return traffic;
    }

    public List<Traffic> getTrafficList(){
        ArrayList<Traffic> arr = Lists.newArrayList(trafficRepository.findAll());
        return arr;
    }

    public List<Traffic> getTrafficList(Date date){
        List<Traffic> all = getTrafficList();
        ArrayList<Traffic> traffic = new ArrayList<Traffic>();
        return traffic;
    }

    public List<Traffic> getTrafficList(long regionId, long serverId){
        List<Traffic> all = getTrafficList(serverId);
        ArrayList<Traffic> traffic = new ArrayList<Traffic>();
        for(int i = 0; i < all.size(); ++i){
            Traffic t = all.get(i);
            if(t.getRegion().getId() == regionId)
                traffic.add(t);
        }
        return traffic;
    }

    public void delete(){
        trafficRepository.deleteAll();
    }
}
