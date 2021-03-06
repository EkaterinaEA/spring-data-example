package com.rightline.springquartz;

import com.rightline.springquartz.JobMerchant;
import com.rightline.springquartz.JobSchedule;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class TriggerJobMerchant {

    public void startMerchantAction() throws SchedulerException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(JobMerchant.class).withIdentity("jobDetailMerchantAction",
                "jobDetailGroupMerchantAction").build();

        String cron = JobSchedule.getSchedule().getCron();

        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.start();
    }
}
