package com.udayam.bablookumar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udayam.bablookumar.entity.Stats;

@Repository
public interface StatsRepository extends CrudRepository<Stats, Integer> {
    
}
