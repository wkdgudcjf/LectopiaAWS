package com.example.category.service;

import com.example.category.entity.Url;
import com.example.category.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UrlService {
    @Autowired
    private UrlRepository urlRepository;

    public Url getUrl(long id){
        return urlRepository.findOne(id);
    }
    public void saveUrl(Url url){
        urlRepository.save(url);
    }

    public Iterable<Url> getAll(){
        return urlRepository.findAll();

    }
}
