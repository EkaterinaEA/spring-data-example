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

        /*
        // обход по всем группам
        for (String groupName : config.getJobGroupNames()) {
            // обход по всем job группы
            for (JobKey jobKey : config.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                String jobName = jobKey.getName();
                String jobGroup = jobKey.getGroup();
                if (jobName.equals("jobDetailMerchantAction")) {

                    // нашли все триггеры
                    List<Trigger> triggers = (List<Trigger>) config.getTriggersOfJob(jobKey);
                    if (triggers.isEmpty()) {
                        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                                .withSchedule(CronScheduleBuilder.cronSchedule(JobSchedule.getSchedule().getCron())).build();
                        config.scheduleJob(jobDetail, trigger);
                    } else {
                        for (Trigger tr : triggers) {
                            CronTrigger trigger = (CronTrigger) tr;
                            if (tr instanceof TriggerJobMerchant && tr.getClass().getName().equals("TriggerJobMerchant")) {
                                trigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "group2")
                                        .withSchedule(CronScheduleBuilder.cronSchedule(JobSchedule.getSchedule().getCron())).build();
                            }
                            config.scheduleJob(jobDetail, trigger);
                        }
                    }
                }
            }
        }

         */
        scheduler.start();
    }
}
