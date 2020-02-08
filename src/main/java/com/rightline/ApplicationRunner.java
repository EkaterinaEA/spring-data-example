package com.rightline;

import com.rightline.springquartz.jdbc_job_store_auto.TriggerJobMerchant;
import com.rightline.springquartz.jdbc_job_store_auto.TriggerJobSchedule;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApplicationRunner {

    public static void main(String[] args) throws SchedulerException {

        SpringApplication.run(ApplicationRunner.class, args);
     //   TriggerJobMerchant triggerJobMerchant = new TriggerJobMerchant();
     //   TriggerJobSchedule triggerJobSchedule = new TriggerJobSchedule();
     //   triggerJobMerchant.startMerchantAction();
     //   triggerJobSchedule.startCronScheduler();

    }
}
