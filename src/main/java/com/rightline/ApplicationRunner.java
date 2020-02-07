package com.rightline;

import com.rightline.entity.TriggerJobMerchant;
import com.rightline.entity.TriggerJobSchedule;
import org.quartz.*;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@ComponentScan
@SpringBootApplication
@EnableSwagger2
public class ApplicationRunner {

    public static void main(String[] args) throws SchedulerException {

     //   SpringApplication.run(ApplicationRunner.class, args);
        new SpringApplicationBuilder(ApplicationRunner.class).bannerMode(Banner.Mode.OFF).run(args);
        TriggerJobMerchant triggerJobMerchant = new TriggerJobMerchant();
        TriggerJobSchedule triggerJobSchedule = new TriggerJobSchedule();
        triggerJobMerchant.startMerchantAction();
        triggerJobSchedule.startCronScheduler();

/*
        SchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler1 = factory.getScheduler();
        JobDetail job1 = JobBuilder.newJob(JobSchedule.class).withIdentity("job1", "group1").build();
        CronTrigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")).build();
        scheduler1.scheduleJob(job1, trigger1);
        scheduler1.start();

        Scheduler scheduler2 = factory.getScheduler();
        JobDetail job2 = JobBuilder.newJob(JobMerchant.class).withIdentity("job2", "group2").build();
        CronTrigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule(JobSchedule.getSchedule().getCron())).build();
        scheduler2.scheduleJob(job2, trigger2);
        scheduler2.start();

        //"0 0/1 * * * ?"
*/
    }
}
