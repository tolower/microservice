package com.xmair.job.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.ConnectException;

@Component
public class Task1 {

    @Scheduled(cron = "0/10 * * * * *")
    public  void  runTask() {

        System.out.println(System.currentTimeMillis());
    }
}
