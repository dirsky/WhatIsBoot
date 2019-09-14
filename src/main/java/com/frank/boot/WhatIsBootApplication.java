package com.frank.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableAsync
//@EnableScheduling
public class WhatIsBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(WhatIsBootApplication.class, args);
    }

}
