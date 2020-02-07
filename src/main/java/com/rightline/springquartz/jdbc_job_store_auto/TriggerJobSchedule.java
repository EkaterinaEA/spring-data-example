package com.rightline.springquartz.jdbc_job_store_auto;

import com.rightline.entity.JobSchedule;
import org.quartz.*;
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
