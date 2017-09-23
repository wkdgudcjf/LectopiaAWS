package com.example.category.service;

import com.example.category.entity.Region;
import com.example.category.entity.Server;
import com.example.category.repository.RegionRepository;
import com.example.category.repository.ServerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    public List<Region> getRegionList() {
        Iterable<Region> ite = this.regionRepository.findAll();
        List<Region> list = Lists.newArrayList(ite);
        return list;
    }

    public List<String> getRegionNameList() {
        List<Region> list = getRegionList();

        ArrayList<String> strList = new ArrayList<String>();
        for ( Region reg : list ) {
            strList.add(reg.getName());
        }

        return strList;

    }

}
