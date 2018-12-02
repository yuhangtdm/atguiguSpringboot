package com.atguigu.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SeheduledService {
    /**
     * second   minute hour day of month, month  day of week
     */
    //定时任务
    @Scheduled(cron = "1-4 * * * * 1-7")
    public void fun(){
        System.out.println("hello");
    }
}
