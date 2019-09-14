package com.frank.boot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScheduleService {
    @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT")
    public void hello() {
        log.info("Schedule 0,1,2,3,4 * * * * MON-SAT");
    }
    @Scheduled(cron = "0/4 * * * * 1-6")
    public void hello2() {
        log.info("ScheduleS 0/4 * * * * 1-6");
    }
}
