package com.rightline;

import com.rightline.springquartz.TimeManger;
import org.quartz.SchedulerException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ApplicationRunner {

    public static void main(String[] args) throws SchedulerException {

        SpringApplication.run(ApplicationRunner.class, args);
        TimeManger timeManger = new TimeManger();
        timeManger.start();

    }
}
