package com.frank.boot.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class RabbitController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public void send() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("title", "标题");
        map.put("content", "内容");

        rabbitTemplate.convertAndSend("exchange.direct", "med.news", map);
    }
}
