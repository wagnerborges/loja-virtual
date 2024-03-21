package com.dev.backend.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/")      
    public String hello() {
        return "Olá Mundo Spring!" + new Date();
    }
    
}
