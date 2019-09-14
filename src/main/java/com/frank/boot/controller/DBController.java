package com.frank.boot.controller;

import com.frank.boot.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {
    @Autowired
    DemoService demoService;
    @GetMapping("/in")
    public String errTest1() {
        demoService.insert();
        return "handle";
    }
    @GetMapping("/in2")
    public String errTest2() {
        demoService.insertWithoutTransactional();
        return "handle";
    }
}
