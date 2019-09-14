package com.frank.boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestExceptionController {
    @GetMapping("/hi")
    public String firstController() {
        if (true) {
            try {
                System.out.println("firstController");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "hi2";
    }

    @GetMapping("/g")
    public Map<String, Object> getHashMap() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("code", 200);
        hashMap.put("msg", "成功");
        return hashMap;
    }

    @GetMapping("/e")
    public String errTest() {
        int a = 1 / 0;
        return "a";
    }


}
