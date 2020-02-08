/*package com.rightline.springquartz.jdbc_job_store_datasource;

import com.rightline.springquartz.jobs.JobMerchant;
import com.rightline.springquartz.jobs.JobSchedule;
import org.quartz.JobDetail;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;

@Configuration
public class QuartzSubmitJobs {
    private static final String CRON_EVERY_MINUTES = "0 0/1 * * * ?";
    String cron = JobSchedule.getSchedule().getCron();

    @Bean(name = "merchant")
    public JobDetailFactoryBean jobMerchant() {
        return QuartzConfig.createJobDetail(JobMerchant.class, "Job Merchant");
    }

    @Bean(name = "merchantTrigger")
    public CronTriggerFactoryBean triggerJobMerchant(@Qualifier("merchant") JobDetail jobDetail) {
        return QuartzConfig.createCronTrigger(jobDetail, cron, "Job Merchant Trigger");
    }

    @Bean(name = "schedule")
    public JobDetailFactoryBean jobSchedule() {
        return QuartzConfig.createJobDetail(JobSchedule.class, "Job Schedule");
    }

    @Bean(name = "scheduleTrigger")
    public CronTriggerFactoryBean triggerJobSchedule(@Qualifier("schedule") JobDetail jobDetail) {
        return QuartzConfig.createCronTrigger(jobDetail, CRON_EVERY_MINUTES, "Job Schedule Trigger");
    }
}
*/
