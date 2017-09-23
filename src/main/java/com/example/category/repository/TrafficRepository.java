package com.example.category.repository;

import com.example.category.entity.Server;
import com.example.category.entity.Traffic;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by ksb on 2017. 9. 23..
 */
public interface TrafficRepository extends CrudRepository<Traffic, Long> {

}
