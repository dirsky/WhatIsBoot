package com.frank.boot.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @Author: GuoZhong Xu
 * @Date: 2019/05/13 7:37
 * @Version 1.0
 */
@Controller
public class ThymeLeafController {
    @RequestMapping("/thyme")
    public String firstThymeLeaf(ModelMap map) {

        map.addAttribute("name", "frank");
        map.addAttribute("msg", "hi Boot");
        map.addAttribute("key", "");
        map.addAttribute("date", new Date());

        List<User> list = Arrays.asList(
            new User(1,"frank",18),
            new User(2,"candy",15),
            new User(3,"dog",3)
        );
        map.addAttribute("list", list);

        Map<String, User> userMap = new HashMap<>();
        userMap.put("u1", new User(1,"张三",20));
        userMap.put("u2", new User(2,"李四",22));
        userMap.put("u3", new User(3,"王五",24));
        map.addAttribute("userMap", userMap);

        System.out.println("Running this method");

        return "hi_thymeleaf";
    }


    @RequestMapping("/thy")
    public String thy(HttpServletRequest request) {
        request.setAttribute("req", "HttpServletRequest-Frank");
        request.getSession().setAttribute("session", "session-frank ");
        request.getSession().getServletContext().setAttribute("app","app-frank");

        return "thymeleaf_more";
    }

    @RequestMapping("/para")
    @ResponseBody
    public String para(Integer id, String name) {

        return "ok" + id + name;
    }
}

@Data
@AllArgsConstructor
class User {
    private Integer id;
    private String name;
    private Integer age;
}

