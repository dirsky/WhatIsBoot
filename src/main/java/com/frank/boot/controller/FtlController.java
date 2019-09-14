package com.frank.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class FtlController {
    /**
     * 需要在pom中开启freemark
     * @param result
     * @return
     */
    @GetMapping("/ftl")
    public String index(Map<String,Object> result) {
        result.put("name", "xgz");
        return "index";
    }
}
