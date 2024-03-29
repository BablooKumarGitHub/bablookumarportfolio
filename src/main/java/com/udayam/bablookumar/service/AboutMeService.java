package com.udayam.bablookumar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.udayam.bablookumar.entity.AboutMe;
import com.udayam.bablookumar.repository.AboutMeRepository;
import com.udayam.bablookumar.util.CacheUtil;

@Service
public class AboutMeService {

    @Autowired
    private AboutMeRepository aboutMeRepository;
    
    @CacheEvict(cacheNames = CacheUtil.ABOUT_ME_CACHE, allEntries = true)
    public void setAboutMe(AboutMe aboutMe) {
        aboutMeRepository.save(aboutMe);
    }

    @Cacheable(cacheNames = CacheUtil.ABOUT_ME_CACHE)
    public String getAboutMe() {
        Optional<AboutMe> optional = aboutMeRepository.findById(1);
        if (!optional.isPresent()) {
            return AboutMe.ABOUT_ME_LOAD_ERROR;
        }
        return optional.get().getText();
    }
}
