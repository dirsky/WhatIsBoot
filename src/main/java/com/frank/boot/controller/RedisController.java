package com.frank.boot.controller;

import com.frank.boot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<Object, Employee> empRedisTemplate;

    @GetMapping("/r1")
    public void testRedis() {
        stringRedisTemplate.opsForValue().append("name", "Frank");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));

    }

    @GetMapping("/r2")
    public void testEmp() {
        Employee employee = new Employee(16,"ln","em",1,3);
        System.out.println(employee);
        empRedisTemplate.opsForValue().set("emp-3",employee);
        System.out.println(empRedisTemplate.opsForValue().get("emp-3"));
    }
}
