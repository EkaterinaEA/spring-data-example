package com.rightline.springquartz;


import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

public class TimeManger {
    public void start() throws SchedulerException {

        // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // And start it off
        scheduler.start();

        Map<JobDetail, Set<? extends Trigger>> triggersAndJobs = new HashMap<>();


        //set up changer schedule job
        JobDetail jobChangerScheduler = newJob(ChangerScheduleJob.class)
                .withIdentity("changerJob")
                .build();

        Trigger triggerChangerScheduler = newTrigger()
                .startNow()
                .withSchedule(cronSchedule("0/05 * * * * ?"))
                .withIdentity("changerTrigger")
                .build();

        //set up executor job
        JobDetail jobExecutor = newJob(ExecutorJob.class)
                .withIdentity("executorJob")
                .build();

        Trigger triggerExecutor = newTrigger()
                .startNow()
                .withIdentity("executorTrigger")
                .withSchedule(cronSchedule("0/10 * * * * ?"))
                .build();

        //add them to map
        triggersAndJobs.put(jobChangerScheduler, Set.of(triggerChangerScheduler));
        triggersAndJobs.put(jobExecutor, Set.of(triggerExecutor));


        //put map of jobs and them triggers in to main scheduler
        scheduler.scheduleJobs(triggersAndJobs, true);
    }
}
