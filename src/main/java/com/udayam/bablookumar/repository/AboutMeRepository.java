package com.udayam.bablookumar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udayam.bablookumar.entity.AboutMe;

@Repository
public interface AboutMeRepository extends CrudRepository<AboutMe, Integer> {
    
}
