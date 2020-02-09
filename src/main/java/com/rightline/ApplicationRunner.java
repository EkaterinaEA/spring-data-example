package com.rightline;

import com.rightline.springquartz.TriggerJobMerchant;
import com.rightline.springquartz.TriggerJobSchedule;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApplicationRunner {

    public static void main(String[] args) throws SchedulerException {

        SpringApplication.run(ApplicationRunner.class, args);
        TriggerJobMerchant triggerJobMerchant = new TriggerJobMerchant();
        TriggerJobSchedule triggerJobSchedule = new TriggerJobSchedule();
        triggerJobMerchant.startMerchantAction();
        triggerJobSchedule.startCronScheduler();
    }
}
