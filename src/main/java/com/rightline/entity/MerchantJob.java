/*package com.rightline.entity;

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
@ConditionalOnProperty("jobs.merchant.enabled")
public class MerchantJob {

    @Scheduled(cron = "#{@scheduleJob.getCron()}")
    public void merchantAction() {
        System.out.println("merchantAction");
        System.out.println(ScheduleJob.getCron());
    }

}

 */
