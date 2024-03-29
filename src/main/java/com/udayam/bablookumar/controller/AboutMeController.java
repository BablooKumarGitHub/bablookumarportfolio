package com.udayam.bablookumar.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udayam.bablookumar.annotation.AuthorizeAdmin;
import com.udayam.bablookumar.annotation.RateLimit;
import com.udayam.bablookumar.entity.AboutMe;
import com.udayam.bablookumar.service.AboutMeService;
import com.udayam.bablookumar.util.Response;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/about_me")
public class AboutMeController {
    
    @Autowired
    private AboutMeService aboutMeService;

    @PutMapping(path = "/update", consumes = "application/json", produces = "application/json")
    @AuthorizeAdmin
    @RateLimit(RateLimit.ADMIN_TOKEN)
    @CrossOrigin
    public ResponseEntity<HashMap<String, Object>> setAboutMe(HttpServletRequest request, @Valid @RequestBody AboutMe aboutMe) {
        aboutMeService.setAboutMe(aboutMe);
        return new ResponseEntity<>(Response.createBody(), HttpStatus.OK);
    }

    @GetMapping(path = "/get", produces = "application/json")
    @RateLimit(RateLimit.DEFAULT_TOKEN)
    @CrossOrigin
    public ResponseEntity<HashMap<String, Object>> getAboutMe(HttpServletRequest request) {
    	
        return new ResponseEntity<>(Response.createBody("text", aboutMeService.getAboutMe()), HttpStatus.OK);
    }
}
