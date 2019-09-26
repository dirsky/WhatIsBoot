package com.frank.boot.controller;

import com.frank.boot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Employee> empRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/r1")
    public void testRedis() {
        stringRedisTemplate.opsForValue().append("name", "Frank");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));

    }

    @GetMapping("/r2")
    public void testEmp() {
        Employee employee = new Employee(16,"ln","em",1,3);
        System.out.println(employee);
        empRedisTemplate.opsForValue().set("emp-4", employee);
        System.out.println(empRedisTemplate.opsForValue().get("emp-4"));

        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Employee.class));
        redisTemplate.opsForValue().set("r-4", employee);
        System.out.println(redisTemplate.opsForValue().get("r-4"));
    }
}
