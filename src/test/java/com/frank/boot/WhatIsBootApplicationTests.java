package com.frank.boot;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhatIsBootApplicationTests {

    @Test
    public void contextLoads() {
        UsernamePasswordToken token = new UsernamePasswordToken("user", "11");
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

}
