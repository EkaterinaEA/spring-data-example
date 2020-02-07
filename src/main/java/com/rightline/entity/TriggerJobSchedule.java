package com.rightline.entity;

import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Scheduler;
import org.quartz.JobDetail;
import org.quartz.JobBuilder;
import org.quartz.CronTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.CronScheduleBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TriggerJobSchedule {

    public void startCronScheduler() throws SchedulerException {

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(JobSchedule.class).withIdentity("jobDetailSchedule", "jobDetailGroupSchedule").build();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?")).build();

        scheduler.scheduleJob(jobDetail, cronTrigger);

        scheduler.start();
    }

}
