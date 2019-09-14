package com.frank.boot.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RabbitReceive {

    /**
     * 监听rabbit的消息
     * @param map
     */
    @RabbitListener(queues = "med.news")
    public void receive(Map<String, Object> map) {
        System.out.println(map);
    }
}
