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
    public Iterable<Traffic> findDateToDate(Date d1, Date d2){

        return null;
    }
    public Iterable<Traffic> findTimeToTime(Date d1, Date d2){
        return null;
    }

    public List<Traffic> getTrafficList(long serverId){
        List<Traffic> all = getTrafficList();
        ArrayList<Traffic> idTraffic = new ArrayList<>();

        for(int i = 0; i < all.size(); ++i){
            Traffic t = all.get(i);
            if(t.getServer().getId() == serverId)
                idTraffic.add(t);
        }
        return idTraffic;
    }
    public List<Traffic> getTrafficList(){
        ArrayList<Traffic> arr = Lists.newArrayList(trafficRepository.findAll());
        return arr;
    }
    public Iterable<Traffic> findByDate(Date date){

        return null;
    }
    public Iterable<Traffic> findByResionId(long regionId){

        return null;
    }

}
