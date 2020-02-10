package com.rightline.springquartz;

import org.quartz.*;

import java.io.IOException;
import java.util.Objects;

import static org.quartz.CronScheduleBuilder.cronSchedule;

public class ChangerScheduleJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            System.out.println("Check change");
            Scheduler currentScheduler = context.getScheduler();

            //********* start persistence layer ***************
            // here could be your DB with time schedulers
            //for example String timeExecutorJob = db.get("timeExecutorJob")
            String timeExecutorJob = "0/10 * * * * ?";
            //********* end persistence layer ***************

            //check context on saved cron timers, if not exist or different from your persistence
            // then change trigger time for ExecutorJob
            String currentTimeExecutorJob = (String) currentScheduler.getContext().get("timeExecutorJob");
            if (!Objects.equals(currentTimeExecutorJob, timeExecutorJob)) {
                System.out.println("Time fire for ExecutorJob was changed");

                try {
                    //get oldTrigger
                    Trigger oldTrigger = currentScheduler.getTrigger(TriggerKey.triggerKey("executorTrigger"));
                    //obtain a builder that would produce the trigger
                    TriggerBuilder tb = oldTrigger.getTriggerBuilder();
                    //update the scheduler associated with the builder, and build the new trigger
                    Trigger newTrigger = tb.withSchedule(cronSchedule(timeExecutorJob)).startNow().build();
                    //update trigger for Executorjob
                    currentScheduler.rescheduleJob(oldTrigger.getKey(), newTrigger);
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
                //save timeExecutorJob to context
                currentScheduler.getContext().put("timeExecutorJob", timeExecutorJob);
            }

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
