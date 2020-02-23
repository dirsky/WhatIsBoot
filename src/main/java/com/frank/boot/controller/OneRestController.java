package com.frank.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 16:27 2019/11/27
 */
//@CrossOrigin
@RestController
public class OneRestController {
    @GetMapping("/")
    public String index(){
        return "HelloWorld Done";
    }
    @GetMapping("/sug")
    public String sug(){
        return "Sug Done";
    }
    @GetMapping("/mock")
    public Map<String, Object> mock(String pageSize){
        System.out.println(pageSize);

        Map<String, Object> map = new HashMap<>();
        map.put("name", "frank");
        return map;
    }
    @GetMapping("/api/sug")
    public String api_sug(){
        return "api Sug Done";
    }
}
