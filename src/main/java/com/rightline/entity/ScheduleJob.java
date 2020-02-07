/*package com.rightline.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@ConditionalOnWebApplication
@ConditionalOnProperty("jobs.schedule.enabled")
public class ScheduleJob {

    private static String cron = "0 0/1 * * * ?";

    @Scheduled(fixedDelayString = "${jobs.schedule.run-delay}")
    public void updatedCron() {
        cron = "0 0/2 * * * ?";
        System.out.println("job1 is running");
    }

    public static String getCron() {
        return cron;
    }
}

//fixedDelay = 1000
//fixedDelayString = "${jobs.schedule.run-delay}"

*/