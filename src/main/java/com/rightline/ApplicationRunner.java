package com.rightline;

import com.rightline.entity.TriggerJobMerchant;
import com.rightline.entity.TriggerJobSchedule;
import org.quartz.SchedulerException;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class ApplicationRunner {

    public static void main(String[] args) throws SchedulerException {

        new SpringApplicationBuilder(ApplicationRunner.class).bannerMode(Banner.Mode.OFF).run(args);
        TriggerJobMerchant triggerJobMerchant = new TriggerJobMerchant();
        TriggerJobSchedule triggerJobSchedule = new TriggerJobSchedule();
        triggerJobMerchant.startMerchantAction();
        triggerJobSchedule.startCronScheduler();

    }
}
