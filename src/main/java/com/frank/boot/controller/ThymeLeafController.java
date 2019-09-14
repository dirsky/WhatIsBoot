package com.frank.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: GuoZhong Xu
 * @Date: 2019/05/13 7:37
 * @Version 1.0
 */
@Controller
public class ThymeLeafController {
    @RequestMapping("/thyme")
    public String firstThymeLeaf(ModelMap map) {
            map.addAttribute("name", "frank's Boot");
        System.out.println("Running this method");
        return "hi_th";
    }
}

