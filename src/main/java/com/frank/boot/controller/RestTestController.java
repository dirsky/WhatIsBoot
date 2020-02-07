package com.frank.boot.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 15:55 2020/2/7
 */
@RestController
@RequestMapping("/hello")
public class RestTestController {
    @GetMapping("/get")
    public String get(String name) {
        return "get " + name;
    }
    @PostMapping("/post")
    public String post(String name) {
        return "post " + name;
    }

    @DeleteMapping("/delete")
    public String delete(String name) {
        return "delete " + name;
    }

    @PutMapping("/put")
    public String put(String name) {
        return "put " + name;
    }
}
