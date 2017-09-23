package com.example.category.repository;

import com.example.category.entity.Server;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ServerRepository extends CrudRepository<Server, Long> {
    Server findByMainUrl(String mainUrl);
//    List<Server> findByTotalMemLessThanEqual(long totalMem);
//    List<Server> findByTotalMemGreaterThanEqual(long totalMem);
      List<Server> findByTotalMemBetween(long min, long max);

//    List<Server> findByUsedMemLessThanEqual(long usedMem);
      List<Server> findByUsedMemBetween(long min, long max);
//    List<Server> findByUsedMemGreaterThanEqual(long usedMem);

    List<Server> findByState(int state);
}
