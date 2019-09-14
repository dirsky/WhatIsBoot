package com.frank.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String index(){
        return "Hello Spring Boot38";
    }
    @Value("${author.name}")
    private String name;
    @Value("${author.title}")
    private String title;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World:"+name+","+title;
    }
}
