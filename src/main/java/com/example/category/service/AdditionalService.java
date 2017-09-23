package com.example.category.service;

import com.example.category.entity.Additional;
import com.example.category.repository.AdditionalRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdditionalService {

    @Autowired
    private AdditionalRepository additionalRepository;

    public List<Additional> getAdditionalList() {
        Iterable<Additional> ite = this.additionalRepository.findAll();
        List<Additional> list = Lists.newArrayList(ite);
        return list;

    }
}
