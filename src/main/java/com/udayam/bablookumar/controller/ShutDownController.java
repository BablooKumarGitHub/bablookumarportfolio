package com.udayam.bablookumar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.udayam.bablookumar.annotation.AuthorizeAdmin;
import com.udayam.bablookumar.annotation.RateLimit;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ShutDownController {

    @DeleteMapping(path = "/shut_down")
    @AuthorizeAdmin
    @RateLimit(RateLimit.EXPENSIVE_TOKEN)
    @CrossOrigin
    public void shutDown(HttpServletRequest request) {
        System.exit(0);
    }
}
