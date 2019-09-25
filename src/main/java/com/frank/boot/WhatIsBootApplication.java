package com.frank.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
//@EnableScheduling
@ServletComponentScan //指定去扫描Servlet注解

public class WhatIsBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhatIsBootApplication.class, args);
        System.out.println("--------Spring OK!!!--------");
    }

}
